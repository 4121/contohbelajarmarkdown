package kepar.john.leonardariraharja.teskepribadian;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leonard ari raharja on 2/15/2015.
 */
public class DBTes extends SQLiteOpenHelper {

    private static final String DB_NAME = "tes";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "soal";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SOAL = "soal";
    private static final String COLUMN_A = "A";
    private static final String COLUMN_B = "B";
    private static final String COLUMN_KETERANGAN = "keterangan";

    private static final String CREATE_SCRIPT = "create table if not exists " + TABLE_NAME + " (" + COLUMN_ID + " integer primary key, " +
        COLUMN_SOAL + " text not null, " + COLUMN_A + " text not null, " + COLUMN_B + " text not null, " + COLUMN_KETERANGAN + " text not null ) ";

    private SQLiteDatabase sqliteDBInstance = null;

    public DBTes(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insert (Soal soal){
        sqliteDBInstance = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_SOAL, soal.getSoal());
        contentValues.put(COLUMN_A, soal.getA());
        contentValues.put(COLUMN_B, soal.getB());
        contentValues.put(COLUMN_KETERANGAN, soal.getKeterangan());
        this.sqliteDBInstance.insert(TABLE_NAME, null, contentValues);
        sqliteDBInstance.close();
    }

    public void hapusSoal(){
        sqliteDBInstance = getWritableDatabase();
        sqliteDBInstance.execSQL("delete from " + TABLE_NAME);
        sqliteDBInstance.close();
    }

    public void insertData(){

        //korelis or plagmatis
        Soal soal1= new Soal();
        soal1.setSoal("Ketika anda menjadi seorang pemimpin dalam tim untuk mencapai tujuan. Yang paling penting menurut anda:");
        soal1.setA("tujuan yang jelas dan kerja keras. semua harus terkontrol dan cepat selesai");
        soal1.setB("cara yang efesien dan mudah. dengan sedikit tekanan pikiran akan terbuka");
        soal1.setKeterangan("k or p");

        //sanguinis or melankolis
        Soal soal2 = new Soal();
        soal2.setSoal("ketika melihat daftar kegiatan anda. apa yang pertama kali anda bayangkan");
        soal2.setA("saya akan melihat daftar kegiatan yang paling saya sukai dan melakukannya dengan optimis");
        soal2.setB("saya akan mempertimbangkan lebih lanjut mengenai apa saja manfaatnya bagi saya");
        soal2.setKeterangan("s or m");

        //korelis or sanguinis
        Soal soal3 = new Soal();
        soal3.setSoal("apa yang pertama kali anda lihat terhadap suatu masalah");
        soal3.setA("mungkin marah tapi saya ingin mengetahui inti masalah tersebut agar cepat selesai");
        soal3.setB("jika mood saya baik saat itu juga akan saya selesaikan");
        soal3.setKeterangan("");

        //plagmatis or sanguinis
        Soal soal4 = new Soal();
        soal4.setSoal("ketika akan ada acara reuni sekolah anda. apa penampilan yang anda pilih:");
        soal4.setA("berpenampilan sebaik mungkin. mungkin saja orang terkesan melihat saya");
        soal4.setB("memakai pakaian seadanya yang penting rapi. saya tidak suka terlalu mencolok");
        soal4.setKeterangan("");

        //korelis or melankolis
        Soal soal5 = new Soal();
        soal5.setSoal("yang paling anda benci saat guru atau pimpinan saat memberikan tugas ke anda. ");
        soal5.setA("terlalu mendikte semua yang saya kerjakan. saya sedikit diberi keleluasaan olehnya");
        soal5.setB("ketika tugas itu terlalu umum tanpa memberikan penjelasan yang detail kepada saya");
        soal5.setKeterangan("");

        //plagmatis or melankolis
        Soal soal6 = new Soal();
        soal6.setSoal("saat anda ingin melakukan suatu kegiatan. apa yang anda inginkan");
        soal6.setA("melakukan hal itu dengan cara yang tepat dan benar serta memperhatikan setiap bagiannya ");
        soal6.setB("melakukannya dengan santai, tanpa tekanan, fleksibel dan tanggung jawab yang tidak terlalu memberatkan");
        soal6.setKeterangan("");

        insert(soal1);
        insert(soal2);
        insert(soal3);
        insert(soal4);
        insert(soal5);
        insert(soal6);
    }

    public List<Soal> getSoal(){
        this.sqliteDBInstance = getWritableDatabase();
        List<Soal> listSoal = new ArrayList<Soal>();
        Cursor cursor = this.sqliteDBInstance.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_SOAL, COLUMN_A, COLUMN_B, COLUMN_KETERANGAN}, null, null, null, null, null);
        if(cursor.getColumnCount() > 0){
            while (cursor.moveToNext()){
                Soal soal = new Soal();
                soal.setId(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
                soal.setSoal(cursor.getString(cursor.getColumnIndex(COLUMN_SOAL)));
                soal.setA(cursor.getString(cursor.getColumnIndex(COLUMN_A)));
                soal.setB(cursor.getString(cursor.getColumnIndex(COLUMN_B)));
                soal.setKeterangan(cursor.getString(cursor.getColumnIndex(COLUMN_KETERANGAN)));
                listSoal.add(soal);
            }
            sqliteDBInstance.close();
            return listSoal;
        } else {
            sqliteDBInstance.close();
            return new ArrayList<Soal>();
        }
    }
}

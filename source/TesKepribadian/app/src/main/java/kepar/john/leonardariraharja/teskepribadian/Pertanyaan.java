package kepar.john.leonardariraharja.teskepribadian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Pertanyaan extends Activity {

    TextView textid, textsoal, textA, textB;

    DBTes db;
    Button milihA, milihB;
    TextView K, S, M, P;

    int index, k, s, m, p;
    String kata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan);

        textsoal = (TextView) findViewById(R.id.textsoal);
        textid = (TextView) findViewById(R.id.textid);
        textA = (TextView) findViewById(R.id.textA);
        textB = (TextView) findViewById(R.id.textB);


        db = new DBTes(this);

        index = 0;
        k = 0;
        s = 0;
        m = 0;
        p = 0;

        Soal soal = db.getSoal().get(0);
        textid.setText(soal.getId());
        textsoal.setText(soal.getSoal());
        textA.setText(soal.getA());
        textB.setText(soal.getB());


        milihA = (Button) findViewById(R.id.btnA);

        milihA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0){
                    Soal soal = db.getSoal().get(1);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 1;
                    kata = "Anda mempunyai keinginan yang kuat dalam mencapai sesuatu. Anda akan merasa stress ketika tugas anda lepas dari kontrol atau dilewati wewenang oleh orang lain. ";
                    k = k + 5 ;


                }

                else if (index == 1){
                    Soal soal = db.getSoal().get(2);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 2;
                    kata = kata + "Anda lebih suka mengerjakan hal yang anda lebih sukai terlebih dahulu dan kekuatan pikiran anda yang optimis membuat anda sebagai orang yang ceria. ";
                    s = s + 5;
                }

                else if (index == 2){
                    Soal soal = db.getSoal().get(3);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 3;
                    kata = kata + "Selalu punya tujuan yang jelas dan kurang memperhatikan hal-hal yang bersifat detail. melakukan segala hal sesuai dengan hal yang ditargetkan. ";
                    k = k + 5;
                }

                else if (index == 3){
                    Soal soal = db.getSoal().get(4);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 4;
                    kata = kata + "Perhatian orang adalah sebuah penghargaan bagi anda maka dari itu sebisa mungkin setiap perhatian tertuju kepada anda. ";
                    s = s + 5;
                }

                else if (index == 4){
                    Soal soal = db.getSoal().get(5);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 5;
                    kata = kata + "anda tidak suka dengan suatu hal yang mengekang anda dalam mengerjakan sesuatu sesuai cara anda. ";
                    k = k + 5 ;
                }

                else if (index == 5){
                    index = 0;
                    m = m + 5;
                    kata = kata + "anda kurang suka suatu hal terlihat cacat sedikit pun atau harus sesuai dengan apa yang sudah dianalisanya";
                    Intent hasil = new Intent(getApplicationContext(), Hasil.class);
                    hasil.putExtra("korelis", k);
                    hasil.putExtra("sanguinis", s);
                    hasil.putExtra("melankolis", m);
                    hasil.putExtra("plagmatis", p);
                    hasil.putExtra("kata", kata);
                    startActivity(hasil);
                    finish();

                }


            }
        });

        milihB = (Button) findViewById(R.id.btnB);

        milihB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0){
                    Soal soal = db.getSoal().get(1);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 1;
                    kata = "Anda selalu mencari cara termudah dalam melakukan suatu hal dan tidak suka sesuatu yang terlihat rumit. Melakukan sesuatu dengan hasil yang baik. ";
                    p = p+5;

                }

                else if (index == 1){
                    Soal soal = db.getSoal().get(2);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 2;
                    kata = kata + "Segala hal yang anda lakukan harus dengan pertimbangan yang matang. melihat ancaman yang ada dan sisi manfaatnya. ";
                    m = m+5;
                }

                else if (index == 2){
                    Soal soal = db.getSoal().get(3);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 3;
                    kata = kata + "Dapat menjadi orang yang mampu memberikan hal positif kepada teman teman anda. ";
                    s=s+5;
                }

                else if (index == 3){
                    Soal soal = db.getSoal().get(4);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 4;
                    kata = kata + "anda adalah orang yang pemalu dan kalem. anda tidak ingin menjadi perhatian seseorang. cukup menjadi diri anda sendiri. ";
                    p=p+5;
                }

                else if (index == 4){
                    Soal soal = db.getSoal().get(5);
                    textid.setText(soal.getId());
                    textsoal.setText(soal.getSoal());
                    textA.setText(soal.getA());
                    textB.setText(soal.getB());
                    index = 5;
                    kata = kata + "tugas yang membutuhkan cara yang tidak pasti tidak terlalu anda sukai. tugas yang anda sukai harus jelas dan punya dasar dasar tertentu. ";
                    m = m + 5;
                }

                else if (index == 5) {
                    kata = kata + "tugas yang membutuhkan kecepatan atau target dan tanggung jawab yang besar mungkin tidak cocok untuk anda";
                    index = 0;
                    p = p + 5;

                    Intent hasil = new Intent(getApplicationContext(), Hasil.class);
                    hasil.putExtra("korelis", k);
                    hasil.putExtra("sanguinis", s);
                    hasil.putExtra("melankolis", m);
                    hasil.putExtra("plagmatis", p);
                    hasil.putExtra("kata", kata);
                    startActivity(hasil);
                    finish();
                }
            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pertanyaan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

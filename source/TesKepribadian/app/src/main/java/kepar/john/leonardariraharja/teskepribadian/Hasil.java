package kepar.john.leonardariraharja.teskepribadian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Hasil extends Activity {

    TextView K, S, M, P;
    int k, s,m ,p;
    String sesuatu, kerja, apaaja, tipe;

    Button Penjelasan, Karir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        K = (TextView) findViewById(R.id.txtK);
        S = (TextView) findViewById(R.id.txtS);
        M = (TextView) findViewById(R.id.txtM);
        P = (TextView) findViewById(R.id.txtP);

        apaaja = K.getText().toString();


            Intent i = getIntent();

            k = i.getIntExtra("korelis", 0);
            s = i.getIntExtra("sanguinis", 0);
            m = i.getIntExtra("melankolis", 0);
            p = i.getIntExtra("plagmatis", 0);
            sesuatu = i.getStringExtra("kata");

            K.setText(Integer.toString(k));
            S.setText(Integer.toString(s));
            M.setText(Integer.toString(m));
            P.setText(Integer.toString(p));


        Penjelasan = (Button) findViewById(R.id.btnPenjelasan);
        Karir = (Button) findViewById(R.id.btnKarir);

        Penjelasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tes = new Intent(getApplicationContext(), Penjelasan.class);
                tes.putExtra("jelasin", sesuatu);

                startActivity(tes);
            }
        });

        Karir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (k > p && k > s && k > m){
                    tipe = "Koleris";
                    kerja = "dapat bekerja sebagai perintis, manager dalam suatu perusahaan, pekerjaan yang dibutuhkannya kecepatan dan target yang jelas.";
                }

                else if (s > m && s > k && s > p){
                    tipe = "Sanguinis";
                    kerja = "cocok bekerja dibidang memasarkan suatu produk atau jasa. komunikator, motivator dan kehumasan dapat menjadi alternatif pekerjaan bagi tipe ini";
                }

                else if (m > k && m > s && m > p){
                    tipe = "Melankolis";
                    kerja = "dapat bekerja dalam bidang analisa, yang membutuhkan ketelitian tinggi, tugas riset dan pengembangan, mengatur mengenai standart kerja, atau penyusunan prosedir atau peraturan tertentu";
                }

                else if (p > k && p > s && p >m){
                    tipe = "Plagmatis";
                    kerja = "pekerjaan yang tidak dibebani target waktu yang mepet. pekerjaan sifatnya rutin dan berulang, pekerjaan yang membutuhkan kecermatan dalam mengambil keputusan dan objectivitas tinggi";
                }

                Intent tes = new Intent(getApplicationContext(), Karir.class);
                tes.putExtra("tip", tipe);
                tes.putExtra("ker", kerja);
                startActivity(tes);
            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hasil, menu);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), Beranda.class);
        startActivity(i);
        finish();

    }
}

package kepar.john.leonardariraharja.teskepribadian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Karir extends Activity {

    TextView tipe, kerja;
    String Tipe, Kerja, jan;
    Button Muleh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karir);


        tipe = (TextView) findViewById(R.id.txtTipe);
        kerja = (TextView) findViewById(R.id.txtKerja);
        jan = tipe.getText().toString();

            Intent aa= getIntent();
            Tipe = aa.getStringExtra("tip");
            Kerja = aa.getStringExtra("ker");

            tipe.setText(Tipe);
            kerja.setText(Kerja);



        Muleh = (Button) findViewById(R.id.btnMuleh);
        Muleh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_karir, menu);
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

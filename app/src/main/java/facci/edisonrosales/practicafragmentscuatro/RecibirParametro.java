package facci.edisonrosales.practicafragmentscuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RecibirParametro extends AppCompatActivity {

    TextView recibirParametro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_parametro);

        recibirParametro=(TextView) findViewById(R.id.lblParametro);

        Bundle bundle=this.getIntent().getExtras();

        recibirParametro.setText(bundle.getString("dato"));


    }
}

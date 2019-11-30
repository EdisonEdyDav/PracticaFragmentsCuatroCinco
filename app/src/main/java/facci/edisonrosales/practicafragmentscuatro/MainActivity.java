package facci.edisonrosales.practicafragmentscuatro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        FragUno.OnFragmentInteractionListener,FragDos.OnFragmentInteractionListener{

    Button botonFragUno, botonFragDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonFragUno=(Button) findViewById(R.id.btnFragUno);
        botonFragDos=(Button) findViewById(R.id.btnFragDos);

        botonFragUno.setOnClickListener(this);
        botonFragDos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnFragUno:
                FragUno fragmentoUno = new FragUno();
                FragmentTransaction transactionUno= getSupportFragmentManager().beginTransaction();
                transactionUno.replace(R.id.contenedor, fragmentoUno );
                transactionUno.commit();
                break;

            case R.id.btnFragDos:
                FragDos fragmentoDos = new FragDos();
                FragmentTransaction transactionDos= getSupportFragmentManager().beginTransaction();
                transactionDos.replace(R.id.contenedor, fragmentoDos );
                transactionDos.commit();
                break;




        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){



        switch (item.getItemId()){
            case R.id.opcionLogin:
                Dialog dialogoLogin= new Dialog(MainActivity.this);
                dialogoLogin.setContentView(R.layout.dlg_login);

                Button botonAutenticar=(Button)dialogoLogin.findViewById(R.id.btnAutenticar);
                final EditText cajaUsuario= (EditText)dialogoLogin.findViewById(R.id.txtUser);
                final EditText cajaClave= (EditText)dialogoLogin.findViewById(R.id.txtPassword);

                botonAutenticar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this,cajaUsuario.getText().toString()+" "+ cajaClave.getText().toString(),Toast.LENGTH_SHORT).show();

                    }

                });

                dialogoLogin.show();

                break;

            case R.id.opcionRegistar:
                Dialog dialogoRegisrar= new Dialog(MainActivity.this);
                dialogoRegisrar.setContentView(R.layout.dlg_registar);

                Button botonRegistar=(Button)dialogoRegisrar.findViewById(R.id.btnRegistar);
                final EditText cajaNombre= (EditText)dialogoRegisrar.findViewById(R.id.txtNombre);
                final EditText cajaDireccion= (EditText)dialogoRegisrar.findViewById(R.id.txtDireccion);
                final EditText cajaTelefono= (EditText)dialogoRegisrar.findViewById(R.id.txtTelefono);

                botonRegistar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this,cajaNombre.getText().toString()+" "+
                                cajaDireccion.getText().toString()+" "+cajaTelefono.getText().toString(),Toast.LENGTH_SHORT).show();



                    }

                });
                dialogoRegisrar.show();



                break;


        }


        return true;
    }


}

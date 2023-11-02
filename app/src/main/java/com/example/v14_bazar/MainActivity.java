package com.example.v14_bazar;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Async Task
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
//

//Login
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//



public class MainActivity extends AppCompatActivity {

    //Async Task
    LinearLayout linearLayout;TextView textView;
    //

    //Variables Login
    EditText editTextUser,editTextPassword;
    Button buttonCerrarSesion;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Async Enlace las var id
        linearLayout = findViewById(R.id.linearLayout);
        textView = findViewById(R.id.textView);
        //

        //Login Enlace var id
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        //

        //Creación de una tarea asincronica
        MyAsyncTask asyncTask = new  MyAsyncTask();
        asyncTask.execute();

    }

    public class MyAsyncTask extends AsyncTask<Void,Void,String>
    {
        @Override
        protected String doInBackground(Void... voids)
        {
            try
            {
                //Accion despues de 5 segundos para retornar valores
                Thread.sleep(3000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return "Proceso Completado";

        }

        protected void onPostExecute(String result)
        {
            //Actualización de interfaz con el resultado
            textView.setText(result);
            //Actualización la imagen
            linearLayout.setVisibility(linearLayout.VISIBLE);
        }
    }

    public void Acceder(View view)
    {
        //obtener el nombre de usuario y la contraseña
        String username = editTextUser.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //Acceso de Usuarios
        if (username.equals("Admin")&& password.equals("1234"))
        {
            Intent intent = new Intent(this,Acceder.class);
            startActivity(intent);
            Toast.makeText(this,"Inicio de sesion exitoso",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Uno o mas datos de los ingresados son Incorrectos",Toast.LENGTH_SHORT).show();
        }
    }

}



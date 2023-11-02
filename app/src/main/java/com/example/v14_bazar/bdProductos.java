package com.example.v14_bazar;

import static com.example.v14_bazar.R.id.lstLista;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class bdProductos extends AppCompatActivity {

    //Declarar variables
    Spinner spSpinner;
    String[] tipo = new String[]{"Frutas", "Verduras", "Abarrotes", "Bebestibles"};
    EditText edtNombre, edtCantidad, edtPrecio;
    ListView lista;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_productos);
        setContentView(R.layout.activity_inventario_productos);

        //Defino los campos del formulario
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtCantidad = (EditText) findViewById(R.id.edtCantidad);
        edtPrecio = (EditText) findViewById(R.id.edtPrecio);
        spSpinner = (Spinner) findViewById(R.id.spSpinner);
        lista = (ListView) findViewById(lstLista);

        //Poblar Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipo);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(spinnerAdapter);
        CargarLista();
    }

    public void onClickIngreso(View view) {
        dbHelper dh = new dbHelper(this, "productos,db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("Nombre", edtNombre.getText().toString());
        reg.put("Cantidad", edtCantidad.getText().toString());
        reg.put("Precio", edtPrecio.getText().toString());
        reg.put("tipo", spSpinner.getSelectedItem().toString());
        long resp = bd.insert("productos", null, reg);
        bd.close();
        if (resp == -1) {
            Toast.makeText(this, "No se puede ingresar el registro", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Registro Agregado", Toast.LENGTH_LONG).show();
        }
        Limpiar();
        CargarLista();
    }

    public void onClickElimino() {

    }

    public void onClickCambio() {

    }

    public void Limpiar() {

    }

    public void CargarLista() {
        dbHelper dh = new dbHelper(this, "productos.db", null, 1);
        SQLiteDatabase bd = dh.getReadableDatabase();
        Cursor c = bd.rawQuery("Select rut, nom, dir, com from productos", null);
        String[] arr = new String[c.getCount()];
        if (c.moveToFirst() == true) {
            int i = 0;
            do {
                String linea = "||" + c.getInt(0) + "||" + c.getString(1)
                        + "||" + c.getString(2) + "||" + c.getString(3) + "||";
                arr[i] = linea;
                i++;
            } while (c.moveToNext() == true);
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, arr);
            lista.setAdapter(adaptador);
            bd.close();
        }
    }

}

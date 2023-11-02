package com.example.v14_bazar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Acceder extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickProductos(View view){
        Toast.makeText(this, "Usted ha presionado la vista de productos", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_inventario_productos);
    }

    public void onClickProveedores(View view){
        Toast.makeText(this, "Usted ha presionado la vista de proveedores", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_mapa_proveedores);
    }

    public void onClickAgregarProductos(View view){
        Toast.makeText(this, "Usted ha presionado agregar productos", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_add_productos);
    }

    public void onClickVolverMenu(View view)
    {
        Toast.makeText(this, "Usted ha presionado volver al Menu", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_menu);
    }

    public void onClickVerInventario(View view)
    {
        Toast.makeText(this, "Usted ha presionado ver el Inventario", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_inventario_productos);
    }

    public void onClickCerrarSesion(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Se ha cerrado la Sesion",Toast.LENGTH_SHORT).show();
    }

}

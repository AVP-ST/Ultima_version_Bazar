package com.example.v14_bazar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper{

    public dbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE productos (tipo INTEGER PRIMARY KEY, nom TEXT, dir TEXT, com TEXT, nota INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS productos");

        // Crea la nueva estructura de la tabla
        db.execSQL("CREATE TABLE productos (rut INTEGER PRIMARY KEY, nom TEXT, dir TEXT, com TEXT, nota INTEGER)");
    }

}

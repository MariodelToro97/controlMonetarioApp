package com.chomy.deudores;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDApp extends SQLiteOpenHelper {

    private String usuario = "CREATE TABLE Usuario (" +
            "user TEXT PRIMARY KEY NOT NULL," +
            "password TEXT NOT NULL," +
            "nombre TEXT NOT NULL," +
            "apePat TEXT NOT NULL," +
            "apeMat TEXT NOT NULL," +
            "email TEXT," +
            "edad  INTEGER DEFAULT 18" +
            ")";

    //Tabla utilizada para cuando se presiona la tecla de recuerdame en el login de la aplicación
    private String recuerdo = "CREATE TABLE Recuerdo (" +
            "nombre TEXT" +
            ")";

    private String deudores = "CREATE TABLE Deudores (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT NOT NULL," +
            "apePat TEXT," +
            "apeMat TEXT," +
            "correo TEXT" +
            ")";

    private String deben = "CREATE TABLE Deben (" +
            "id INTEGER PRIMARY KEY," +
            "userCreate INTEGER NOT NULL," +
            "userDeud TEXT NOT NULL," +
            "total REAL NOT NULL," +
            "totalAbonos REAL NOT NULL," +
            "resto REAL NOT NULL," +
            "fecha TEXT NOT NULL," +
            "detalle TEXT NOT NULL," +
            "FOREIGN KEY (userCreate) REFERENCES Usuario(user)" +
            ")";

    private String abonos = "CREATE TABLE Abonos (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "usuario TEXT NOT NULL," +
            "fecha TEXT NOT NULL," +
            "cantidad INTEGER NOT NULL," +
            "idDeuda INTEGER NOT NULL," +
            "FOREIGN KEY (idDeuda) REFERENCES Deben(id)" +
            ")";

    public BDApp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usuario);
        db.execSQL(recuerdo);
        db.execSQL(deben);
        db.execSQL(abonos);
        db.execSQL(deudores);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.emontec.blue_off;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.emontec.blue_off.utilidades.Utilidades;

/**
 * Created by CHENAO on 7/05/2017.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {



    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_MASCOTA);
        db.execSQL(Utilidades.CREAR_TABLA_CLIENTES);
        db.execSQL(Utilidades.CREAR_TABLA_BODEGAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CLIENTES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_BODEGAS);
        onCreate(db);
    }
}

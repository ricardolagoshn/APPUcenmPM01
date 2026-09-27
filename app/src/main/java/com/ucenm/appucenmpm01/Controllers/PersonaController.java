package com.ucenm.appucenmpm01.Controllers;

import com.ucenm.appucenmpm01.Database.DBConfig;
import com.ucenm.appucenmpm01.Database.DatabaseHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ucenm.appucenmpm01.Database.DatabaseHelper;
import com.ucenm.appucenmpm01.Models.Persona;

public class PersonaController
{
    private final DatabaseHelper databaseHelper;

    public PersonaController(Context context)
    {
        databaseHelper = new DatabaseHelper(context);
    }

    // Metodos Crud
    public long AddPerson(Persona persona)
    {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DBConfig.COLUMN_NAME, persona.getNombres());
        valores.put(DBConfig.COLUMN_APELLIDOS, persona.getApellidos());
        valores.put(DBConfig.COLUMN_FECHANAC, persona.getFechanac());
        valores.put(DBConfig.COLUMN_DIRECCION, persona.getDireccion());
        valores.put(DBConfig.COLUMN_TELEFONO, persona.getTelefono());
        valores.put(DBConfig.COLUMN_CORREO, persona.getCorreo());

        long resultado = db.insert(DBConfig.DROP_TABLE_PERSONAS, null, valores);
        db.close();

        return resultado;
    }
}

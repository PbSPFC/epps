package br.uninove.primeiraconsulta.util;

import android.content.Context;

import br.uninove.primeiraconsulta.database.DataBase;

/**
 * Created by PB on 09/11/2016.
 */

public class DbFactory {

    private static DataBase db;

    public static final DataBase getDB(Context context){
        db = new DataBase(context);
        return db;
    }

}

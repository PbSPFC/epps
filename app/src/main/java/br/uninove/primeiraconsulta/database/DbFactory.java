package br.uninove.primeiraconsulta.database;

import android.content.Context;

/**
 * Created by PB on 09/11/2016.
 */

public class DbFactory {

    public static final DataBase getDB(Context context){
        DataBase db = new DataBase(context);
        return db;
    }

}

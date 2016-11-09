package br.uninove.primeiraconsulta.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.uninove.primeiraconsulta.database.DbStatus;
import br.uninove.primeiraconsulta.entidade.Status;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 09/11/2016.
 */

public class StatusDao {

    public static final StatusDao statusDao = new StatusDao();

    public static Status buscaStatusPorId(Long id, Context context){

        String sql = "select * from " + DbStatus.STATUS_TB_NAME + " where ID = " + id;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Status status = new Status();
                status.setId(cursor.getLong(0));
                status.setStatus(cursor.getString(1));
                db.close();
                return status;
            }while(cursor.moveToNext());
        }

        db.close();
        return null;
    }

}

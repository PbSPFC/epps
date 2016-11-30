package br.uninove.primeiraconsulta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.database.DbUsuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 09/11/2016.
 */

public class UsuarioDao {

    public static final int ID = 0;
    public static final int RA = 1;
    public static final int SENHA = 2;
    public static final int NOME = 3;
    public static final int EMAIL = 4;
    public static final int STATUS_ID = 5;


    public static final String id = "id";
    public static final String ra = "ra";
    public static final String senha = "senha";
    public static final String nome = "nome";
    public static final String email = "email";
    public static final String statusId = "status_id";



    public static void salvar(Usuario usuario, Context context) throws Exception {
        //Instancia o Banco de Dados
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        try{
        //Persistindo valores do objeto no BD
        values.put(ra, usuario.getRa());
        values.put(senha, usuario.getSenha());
        values.put(nome, usuario.getNome());
        values.put(email, usuario.getEmail());
        values.put(statusId, usuario.getStatus().getId());
        //Verificando se ira fazer udpate ou insert
        if(usuario.getId()==null) {
            db.insert(DbUsuario.USUARIO_TB_NAME, null, values);
        }else{
            db.update(DbUsuario.USUARIO_TB_NAME, values, "id = ?", new String[]{usuario.getId().toString()});
        }
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }

    }

    public static Usuario buscarUsuarioPorId(Long id, Context context) throws Exception {

        String sql = "select * from " + DbUsuario.USUARIO_TB_NAME + " where ID = " + id;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        try{
        if(cursor.moveToFirst()){
            do{
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getLong(ID));
                usuario.setRa(cursor.getString(RA));
                usuario.setSenha(cursor.getString(SENHA));
                usuario.setNome(cursor.getString(NOME));
                usuario.setEmail(cursor.getString(EMAIL));
                usuario.setStatus(StatusDao.buscaStatusPorId(cursor.getLong(STATUS_ID), context));


                db.close();
                return usuario;
            }while(cursor.moveToNext());
        }

        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }
        return null;
    }


    public static List<Usuario> buscarTodosUsuarios(Context context) throws Exception {
        List<Usuario> lista = new ArrayList<>();

        String sql = "select * from " + DbUsuario.USUARIO_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        try{
        if(cursor.moveToFirst()){
            do{

                Usuario usuario = new Usuario();
                usuario.setId(cursor.getLong(ID));
                usuario.setRa(cursor.getString(RA));
                usuario.setSenha(cursor.getString(SENHA));
                usuario.setNome(cursor.getString(NOME));
                usuario.setEmail(cursor.getString(EMAIL));
                usuario.setStatus(StatusDao.buscaStatusPorId(cursor.getLong(STATUS_ID), context));

                lista.add(usuario);

            }while(cursor.moveToNext());
        }


        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }
        return lista;
    }

    public static void excluirUsuario(Usuario usuario, Context context) throws Exception {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        try{
        db.delete(DbUsuario.USUARIO_TB_NAME, "id=?", new String[]{usuario.getId() + ""});
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }
    }

}

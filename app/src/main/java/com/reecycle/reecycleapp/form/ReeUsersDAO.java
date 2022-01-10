package com.reecycle.reecycleapp.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.reecycle.reecycleapp.form.SlidePages.Artigos.ArtigosModel;

import java.util.List;

class ReeUsersDAO {
    private ReeUserDatabase reeUserDatabase;
    private SQLiteDatabase banco;

    ReeUsersDAO(Context context){
        reeUserDatabase = new ReeUserDatabase(context);
        banco = reeUserDatabase.getWritableDatabase();
    }

    void insertReeUser(ReeUsers reeUsers){
        ContentValues values = new ContentValues();
        values.put("nome", reeUsers.getNome());
        values.put("sobrenome", reeUsers.getSobrenome());
        values.put("telefone", reeUsers.getTelefone());
        values.put("email", reeUsers.getEmail());
        values.put("senha", reeUsers.getSenha());
        values.put("confSenha", reeUsers.getConfSenha());
        values.put("municipio", reeUsers.getMunicipio());
        banco.insert("reeusers", null, values);
    }

    ReeUsers pickReeUser(ReeUsers reeUsers){
        ReeUsers r;

        banco = reeUserDatabase.getReadableDatabase();

        String query = "SELECT nome, sobrenome, telefone, email, senha FROM reeusers WHERE email LIKE ? AND senha LIKE ?";
        Cursor cursor = banco.rawQuery(query, new String[]{reeUsers.getEmail(), reeUsers.getSenha()});
        cursor.moveToFirst();

        if(cursor.moveToFirst() && cursor.getCount() > 0) {
            r = new ReeUsers();
            r.setNome(cursor.getString(0));
            r.setSobrenome(cursor.getString(1));
            r.setTelefone(cursor.getString(2));
            r.setEmail(cursor.getString(3));
            r.setSenha(cursor.getString(4));
            if (reeUsers.getSenha().equalsIgnoreCase(r.getSenha()))
                return r;
        }

        cursor.close();
        banco.close();

        return null;
    }



    //public boolean isEmailExists(){

    //}




}

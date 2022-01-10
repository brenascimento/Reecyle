package com.reecycle.reecycleapp.form;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ReeUserDatabase extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;
    private static final String tablename = "reeusers";

    public ReeUserDatabase(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + tablename + "(id integer primary key autoincrement, " +
                "nome varchar(50) not null, sobrenome varchar(50) not null, telefone varchar(60), email varchar(60) not null," +
                "senha varchar(50) not null, confSenha varchar(50) not null, municipio varchar(40))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + tablename;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }
}

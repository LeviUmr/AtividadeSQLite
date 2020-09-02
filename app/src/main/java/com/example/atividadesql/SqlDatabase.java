package com.example.atividadesql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//Extender a classe com o SQLiteOpenHelper
public class SqlDatabase extends SQLiteOpenHelper {

    //Criando Variáveis globais e constantes
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SqlDatabase.db";

    //Criando tabelas
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE filmes ("+
                    "id INTEGER PRIMARY KEY," +
                    "nome_filme TEXT,"+
                    "desc_filme TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS filmes";

    //Criar o construtor Super
    public SqlDatabase(@Nullable Context context) {
        //Remover "@Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version"

        //(Contexto, NomeBanco, retorno, Versão)
        super(context, DATABASE_NAME, null , DATABASE_VERSION);

    }

    //Implementar os Métodos com alt+enter
    @Override
    public void onCreate(SQLiteDatabase db) {
        //executa a criação da tabela
        db.execSQL(SQL_CREATE_ENTRIES);
        //comando que chama a criação da tabela
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Deleta as tabelas
        db.execSQL(SQL_DELETE_ENTRIES);
        //cria novamente
        onCreate(db);

    }
}

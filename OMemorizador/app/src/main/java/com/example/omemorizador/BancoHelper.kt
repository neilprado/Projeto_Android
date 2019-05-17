package com.example.omemorizador

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper (context: Context): SQLiteOpenHelper(context, "banco", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {

        val sql = "create table professor (" + "id integer primary key autoincrement, " +
                "nome text, " + "image id" + ")"
        db?.execSQL(sql)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "drop table if exists " + "professor"
        db?.execSQL(sql)
        onCreate(db)
    }
}
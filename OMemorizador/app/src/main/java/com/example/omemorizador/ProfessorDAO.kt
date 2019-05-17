package com.example.omemorizador

import android.content.ContentValues
import android.content.Context
import android.util.Log

class ProfessorDAO {
    private lateinit var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(p: Professor){
        val cv = ContentValues()
        cv.put("nome", p.nome)
        this.banco.writableDatabase.insert("professor", null, cv)
    }

    fun get(): ArrayList<Professor>{
        val colunas = arrayOf("id", "nome")
        val lista = ArrayList<Professor>()

        val l = this.banco.readableDatabase.query("professor", colunas, null, null, null, null, null)

        l.moveToFirst()
        if(l.count > 0){
            do{
                val id = l.getInt(l.getColumnIndex("id"))
                val nome = l.getString(l.getColumnIndex("nome"))
                lista.add(Professor(id, nome))
            }while (l.moveToNext())

            Log.e("APP_MEMORIZADOR", lista.toString())
        }
        return lista
    }

    fun get(index: Int): Professor?{
        val colunas = arrayOf("id", "nome")
        val where = "id = ?"
        val arg = arrayOf(index.toString())

        val l = this.banco.readableDatabase.query("professor", colunas, where, arg, null, null, null)
        l.moveToFirst()

        if(l.count > 0){
            val id = l.getInt(l.getColumnIndex("id"))
            val nome = l.getString(l.getColumnIndex("nome"))
            return Professor(id, nome)
        }
        return null
    }

    fun update(p: Professor){
        val where = "id = ?"
        val arg = arrayOf(p.id.toString())
        val cv = ContentValues()

        cv.put("id", p.id)
        cv.put("nome", p.nome)
        this.banco.writableDatabase.update("professor", cv, where, arg)
    }

    fun delete(index: Int){
        val where = "id = ?"
        val arg = arrayOf(index.toString())

        this.banco.writableDatabase.delete("professor", where, arg)
    }
}
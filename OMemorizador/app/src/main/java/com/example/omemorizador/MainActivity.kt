package com.example.omemorizador

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btListar: Button
    private lateinit var btPlay: Button
    var lista = ArrayList<Professor>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btListar = findViewById(R.id.btListar)
        this.btListar.setOnClickListener({listarProfessores(it)})

        this.btPlay = findViewById(R.id.btJogar)
        this.btPlay.setOnClickListener({jogoMemoria(it)})
    }



    fun listarProfessores(view: View){
        var intent = Intent(this, ListarActivity::class.java)
        startActivity(intent)
    }

    fun jogoMemoria(view: View){
        var intent = Intent(this, JogarActivity::class.java)
        intent.putExtra("MSG_JOGAR", "Iniciando o jogo")
        startActivity(intent)
    }
}
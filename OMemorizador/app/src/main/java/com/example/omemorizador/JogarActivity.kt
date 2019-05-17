package com.example.omemorizador

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast

class JogarActivity : AppCompatActivity() {
    private lateinit var gv_game: GridView
    private var first: ImageView? = null
    private var second: ImageView? = null
    private var count = 0
    private var match = false

    val pics = intArrayOf(
        R.drawable.alana,
        R.drawable.alex,
        R.drawable.candido,
        R.drawable.crishane,
        R.drawable.damires,
        R.drawable.denio,
        R.drawable.edemberg,
        R.drawable.fausto,
        R.drawable.francisco,
        R.drawable.fred,
        R.drawable.giovanni,
        R.drawable.gustavo,
        R.drawable.heremita,
        R.drawable.juliana,
        R.drawable.lafayette,
        R.drawable.leonidas,
        R.drawable.luiz,
        R.drawable.nilton,
        R.drawable.paulo,
        R.drawable.petronio,
        R.drawable.pryscilla,
        R.drawable.thiago,
        R.drawable.valeria,
        R.drawable.varandas,
        R.drawable.zefilho
    ).toList().shuffled()

    var pos = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7).toList().shuffled()
    var currPos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gv_game = findViewById(R.id.gvGame)
        val adapter = ProfessorAdapter(this)
        gv_game.adapter = adapter

        gv_game.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            if (currPos < 0) {
                if(!match){
                    first?.setImageResource(R.drawable.hidden)
                    second?.setImageResource(R.drawable.hidden)
                    match = false
                }
                currPos = position
                first = view as ImageView
                view.setImageResource(pics[pos[position]])
            } else {
                if (currPos == position) {
                    Toast.makeText(this@JogarActivity, "Esta carta já foi escolhida", Toast.LENGTH_SHORT).show()
                } else if (pos[currPos] !== pos[position]) {
                    (view as ImageView).setImageResource(pics[pos[position]])
                    currPos = -1
                    match = false
                    second = view
                    Toast.makeText(this@JogarActivity, "Not match, please try again", Toast.LENGTH_SHORT).show()
                } else {
                    (view as ImageView).setImageResource(pics[pos[position]])
                    count += 1
                    currPos = -1
                    match = true
                    second = view
                    first?.setOnClickListener(null)
                    second?.setOnClickListener(null)
                    Toast.makeText(this@JogarActivity, "Well done!!", Toast.LENGTH_LONG).show()
                }
                if (count == 8) {
                    Toast.makeText(this@JogarActivity, "Well done, you rock!", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}
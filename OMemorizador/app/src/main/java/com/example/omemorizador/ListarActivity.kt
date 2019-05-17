package com.example.omemorizador

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class ListarActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    lateinit var dao: ProfessorDAO
    private lateinit var professores : ArrayList<Professor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        this.dao = ProfessorDAO(this)
        adicionar()
        listView = findViewById(R.id.lvProfessores)
        professores = dao.get()
        val adapter = ListAdapter(this, professores)
        listView.adapter = adapter

        Log.e("APP_MEMORIZADOR", professores.toString())

    }

    fun adicionar(){
        dao.insert(Professor("Alana"))
        dao.insert(Professor("Alex"))
        dao.insert(Professor("Candido"))
        dao.insert(Professor("Crishane"))
        dao.insert(Professor("Damires"))
        dao.insert(Professor("Denio"))
        dao.insert(Professor("Edemberg"))
        dao.insert(Professor("Fausto"))
        dao.insert(Professor("Francisco"))
        dao.insert(Professor("Fred"))
        dao.insert(Professor("Giovanni"))
        dao.insert(Professor("Gustavo"))
        dao.insert(Professor("Heremita"))
        dao.insert(Professor("Juliana"))
        dao.insert(Professor("Lafayette"))
        dao.insert(Professor("Leonidas"))
        dao.insert(Professor("Luiz"))
        dao.insert(Professor("Nilton"))
        dao.insert(Professor("Paulo"))
        dao.insert(Professor("Petrônio"))
        dao.insert(Professor("Pryscilla"))
        dao.insert(Professor("Thiago"))
        dao.insert(Professor("Valeria"))
        dao.insert(Professor("Marcus Varandas"))
        dao.insert(Professor("Zé Filho"))
    }

    inner class ListAdapter(context: Context, private val professores: ArrayList<Professor>): BaseAdapter(){
        private val inflator: LayoutInflater = LayoutInflater.from(context)

        override fun getCount(): Int {
            return professores.size
        }

        override fun getItem(position: Int): Any {
            return professores[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view : View
            val holder: ViewHolder

            if(convertView == null){
                view = this.inflator.inflate(R.layout.activity_list_unit, parent, false)
                holder = ViewHolder(view)
                view.setTag(holder)
            }else{
                view = convertView
                holder = view.getTag() as ViewHolder
            }
            val p: Professor = professores[position]
            holder.nome.text = p.nome
            return view
        }

        inner class ViewHolder(){
            lateinit var nome: TextView

            constructor(view: View): this(){
                this.nome = view.findViewById(R.id.tvUnit)
            }
        }
    }
}
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
        dao.insert(Professor("Alana Marques de Morais"))
        dao.insert(Professor("Alex Sandro da Cunha Rego"))
        dao.insert(Professor("Candido Jose Ramos do Egypto"))
        dao.insert(Professor("Crishane Azevedo Freire"))
        dao.insert(Professor("Damires Yluska de Souza Fernandes"))
        dao.insert(Professor("Denio Mariz Timoteo de Sousa"))
        dao.insert(Professor("Edemberg Rocha da Silva"))
        dao.insert(Professor("Fausto Veras Maranhao Ayres"))
        dao.insert(Professor("Francisco Dantas Nobre Neto"))
        dao.insert(Professor("Frederico Costa Guedes Pereira"))
        dao.insert(Professor("Giovanni Loureiro Franca de Mendonca"))
        dao.insert(Professor("Gustavo Wagner Diniz Mendes"))
        dao.insert(Professor("Heremita Brasileiro Lira"))
        dao.insert(Professor("Juliana Dantas Ribeiro Viana de Medeiros"))
        dao.insert(Professor("Lafayette Batista Melo"))
        dao.insert(Professor("Leonidas Francisco de Lima Junior"))
        dao.insert(Professor("Luiz Carlos Rodrigues Chaves"))
        dao.insert(Professor("Nilton Freire Santos"))
        dao.insert(Professor("Paulo Roberto Santos Costa"))
        dao.insert(Professor("Francisco Petronio Alencar de Medeiros"))
        dao.insert(Professor("Pryscilla Marcili Dora"))
        dao.insert(Professor("Thiago Jose Marques Moura"))
        dao.insert(Professor("Valeria Maria Bezerra Cavalcanti Maciel"))
        dao.insert(Professor("Marcus Vinicius Delgado Varandas"))
        dao.insert(Professor("Jose Gomes Quaresma Filho"))
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
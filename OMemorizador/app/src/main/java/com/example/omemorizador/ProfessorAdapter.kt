package com.example.omemorizador

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ProfessorAdapter(private val context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return 16
    }

    override fun getItem(position: Int) : Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: ImageView
        if (convertView == null) {
            view = ImageView(this.context)
            view.setLayoutParams(AbsListView.LayoutParams(100, 100))
            view.scaleType = ImageView.ScaleType.FIT_XY
        }
        else {
            view = convertView as ImageView
        }
            view.setImageResource(R.drawable.hidden)


        return view
    }
}
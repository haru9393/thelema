package com.example.thelema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.thelema.R

class MiAdaptador(context: Context, data: List<Pair<String, String>>) :
    ArrayAdapter<Pair<String, String>>(context, R.layout.list_item, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val item = getItem(position)

        val text1 = view.findViewById<TextView>(R.id.text1)
        val text2 = view.findViewById<TextView>(R.id.text2)

        text1.text = item?.first ?: ""
        text2.text = item?.second ?: ""

        return view
    }
}
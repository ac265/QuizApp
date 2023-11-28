package com.example.kpsssnavsorular

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewDataAdapter(private val dataSet: ArrayList<*>, mContext: Context) :
    ArrayAdapter<Any?>(mContext, R.layout.raw_list_view_item, dataSet) {
    private class ViewHolder {
        lateinit var txtName: TextView
        lateinit var imageView: ImageView
    }

    override fun getCount(): Int {
        return dataSet.size
    }

    override fun getItem(position: Int): DataModel {
        return dataSet[position] as DataModel
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        val result: View
        if (convertView == null) {
            viewHolder = ViewHolder()
            convertView =
                LayoutInflater.from(parent.context).inflate(R.layout.raw_list_view_item, parent, false)
            viewHolder.txtName =
                convertView.findViewById(R.id.txtName)
            viewHolder.imageView =
                convertView.findViewById(R.id.imageView)
            result = convertView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            result = convertView
        }

        val item: DataModel = getItem(position)
        viewHolder.txtName.text = item.name
        viewHolder.imageView.setImageResource(item.source)
        return result
    }
}
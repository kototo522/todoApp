package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Affirmation(val stringResourceId: Int)

class Datasource{
    fun loadTitles(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.titleList1),
            Affirmation(R.string.titleList2),
            Affirmation(R.string.titleList3),
            Affirmation(R.string.titleList4),
            Affirmation(R.string.titleList5)
        )
    }

    fun loadTexts(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.textList1),
            Affirmation(R.string.textList2),
            Affirmation(R.string.textList3),
            Affirmation(R.string.textList4),
            Affirmation(R.string.textList5)
        )
    }
}

class ItemAdapter(
    private val context: Context,
    private val titleList: List<Affirmation>,
    private val textList: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.titleView)
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.sticky_note, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.titleView.text = context.resources.getString(titleList[position].stringResourceId)
        holder.textView.text = context.resources.getString(textList[position].stringResourceId)
    }

    override fun getItemCount() = titleList.size
}
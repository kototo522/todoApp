package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Datasource
import com.example.todoapp.ItemAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val dataset = Datasource()
        recyclerView.adapter = ItemAdapter(this, dataset.loadTitles(), dataset.loadTexts())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
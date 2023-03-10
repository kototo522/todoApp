package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val dataset = Datasource()
        recyclerView.adapter = ItemAdapter(this, dataset.loadTitles(), dataset.loadTexts())
        recyclerView.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.input_button)

        button.setOnClickListener{
            Toast.makeText(this, "ボタンが押されました", Toast.LENGTH_LONG).show()
            val modalBottomSheet = ModalBottomSheet()
            modalBottomSheet.show(supportFragmentManager, ModalBottomSheet.TAG)
        }
    }
}
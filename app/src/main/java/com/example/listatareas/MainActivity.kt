package com.example.listatareas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvTareas : ListView = findViewById(R.id.lvTareas)
        val lista : MutableList<String> = mutableListOf()
        lista.add("Lunes")
        lista.add("Martes")
        lista.add("Miércoles")
        lista.add("Jueves")
        lista.add("Viernes")
        lista.add("Sábado")
        lista.add("Domingo")

        val adapter : ArrayAdapter<String> = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            lista
        )

        lvTareas.adapter = adapter
    }
}
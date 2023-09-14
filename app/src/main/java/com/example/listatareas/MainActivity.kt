package com.example.listatareas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var alerta : AlertDialog.Builder
    private lateinit var  lista : MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvTareas : ListView = findViewById(R.id.lvTareas)
         lista = mutableListOf()

        val adapter : ArrayAdapter<String> = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            lista
        )

        lvTareas.adapter = adapter
        ///////////
        configurarAlertaTarea()
        val fabNuevo : FloatingActionButton = findViewById(R.id.fabNuevo)

        fabNuevo.setOnClickListener {
        configurarAlertaTarea()
        }
    }


    private fun configurarAlertaTarea() {
         alerta = AlertDialog.Builder(this) //permite configurar las caracterrísticas del alert

        alerta.setTitle(getString(R.string.mis_tareas)) //titulo ventana

        val layout = layoutInflater.inflate(R.layout.dialogo_texto_tarea, null) //inflate en programación es cuando un recurso es cargado a memoria, para que esté disponible
        val etTarea : EditText = layout.findViewById(R.id.etTarea) //al contruir el diálogo se encuentra la variable en este documento

        alerta.setView(layout)
        alerta.setPositiveButton(getString(R.string.aceptar)){ dialogInterface, i ->
        agregarTarea(etTarea.text.toString())
        }

        alerta.create().show()
    }

    private fun agregarTarea(tarea: String) {
        if(tarea.isNotEmpty()){
            lista.add( tarea )
        }
    }
}
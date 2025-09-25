package com.example.practicacomunicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/**
 * Descripción: Actividad principal que funciona como un menú para lanzar los ejercicios.
 * Autor: Iben Flores Polanco
 * Fecha creación: 25/09/2025
 * Fecha última modificación: 25/09/2025
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnIrAPerfil).setOnClickListener {
            startActivity(Intent(this, FormularioActivity::class.java))
        }

        findViewById<Button>(R.id.btnIrANota).setOnClickListener {
            startActivity(Intent(this, EditorActivity::class.java))
        }
    }
}
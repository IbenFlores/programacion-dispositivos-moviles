/**
 * Descripción corta: Muestra un Toast al hacer clic en una imagen.
 * Autor: Iben Omar Flores Polanco
 * Fecha creación: 09/09/2025
 * Fecha última modificación: 09/09/2025
 */

package com.example.practica_3_ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener la referencia a la ImageView del layout
        val imageView: ImageView = findViewById(R.id.myImageView)

        // Configurar el OnClickListener para la imagen
        imageView.setOnClickListener {
            // Mostrar un Toast con un mensaje personalizado
            Toast.makeText(this, "¡Hola! Has hecho clic en el logo de Android", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.practicacomunicacion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * Descripción: Muestra la nota recibida y ofrece opciones para compartir o editar de nuevo.
 * Autor: Iben Flores Polanco
 * Fecha creación: 25/09/2025
 * Fecha última modificación: 25/09/2025
 */
class OpcionesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOTA_ENVIADA = "extra_nota_enviada"
        const val EXTRA_NOTA_DEVUELTA = "extra_nota_devuelta"
    }

    private lateinit var notaRecibida: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val tvNota: TextView = findViewById(R.id.tvNota)
        val btnCompartirCorreo: Button = findViewById(R.id.btnCompartirCorreo)
        val btnEditarNuevo: Button = findViewById(R.id.btnEditarNuevo)

        notaRecibida = intent.getStringExtra(EXTRA_NOTA_ENVIADA) ?: ""
        tvNota.text = getString(R.string.label_nota) + " " + notaRecibida

        btnCompartirCorreo.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_compartido_correo), Toast.LENGTH_SHORT).show() // [cite: 38]
        }

        btnEditarNuevo.setOnClickListener { // [cite: 39]
            val resultIntent = Intent().apply {
                putExtra(EXTRA_NOTA_DEVUELTA, notaRecibida)
            }
            setResult(Activity.RESULT_OK, resultIntent) // [cite: 45]
            finish()
        }
    }
}
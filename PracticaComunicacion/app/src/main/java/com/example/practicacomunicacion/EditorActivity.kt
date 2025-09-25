package com.example.practicacomunicacion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

/**
 * Descripción: Permite escribir una nota y enviarla a otra actividad para ver opciones.
 * Autor: Iben Flores Polanco
 * Fecha creación: 25/09/2025
 * Fecha última modificación: 25/09/2025
 */
class EditorActivity : AppCompatActivity() {

    private lateinit var etNota: EditText
    private lateinit var btnCompartir: Button

    private companion object {
        const val KEY_NOTA = "key_nota"
    }

    /**
     * Contrato que maneja el resultado devuelto por OpcionesActivity. [cite: 42]
     */
    private val opcionesActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val notaDeVuelta = result.data?.getStringExtra(OpcionesActivity.EXTRA_NOTA_DEVUELTA)
            etNota.setText(notaDeVuelta)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        etNota = findViewById(R.id.etNota)
        btnCompartir = findViewById(R.id.btnCompartir)

        btnCompartir.setOnClickListener {
            val notaTexto = etNota.text.toString()
            val intent = Intent(this, OpcionesActivity::class.java).apply {
                putExtra(OpcionesActivity.EXTRA_NOTA_ENVIADA, notaTexto) // [cite: 45]
            }
            opcionesActivityResultLauncher.launch(intent)
        }
    }

    /**
     * Guarda el texto de la nota si la actividad se destruye (ej. por rotación). [cite: 43, 46]
     * @param outState Bundle para guardar el estado.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NOTA, etNota.text.toString())
    }

    /**
     * Restaura el texto de la nota después de que la actividad se recrea.
     * @param savedInstanceState Bundle con el estado guardado.
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        etNota.setText(savedInstanceState.getString(KEY_NOTA))
    }
}
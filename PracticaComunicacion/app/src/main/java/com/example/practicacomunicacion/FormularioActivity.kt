package com.example.practicacomunicacion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

/**
 * Descripción: Permite al usuario llenar un formulario de perfil y lo envía para confirmación.
 * Autor: Iben Flores Polanco
 * Fecha creación: 25/09/2025
 * Fecha última modificación: 25/09/2025
 */
class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    private companion object {
        const val KEY_NOMBRE = "key_nombre"
        const val KEY_EDAD = "key_edad"
        const val KEY_CIUDAD = "key_ciudad"
        const val KEY_CORREO = "key_correo"
    }

    /**
     * Contrato para recibir el resultado de ResumenActivity. [cite: 21]
     */
    private val resumenActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // El usuario confirmó, mostramos el Toast y limpiamos los campos. [cite: 17]
            Toast.makeText(this, getString(R.string.toast_perfil_guardado), Toast.LENGTH_SHORT).show()
            etNombre.text.clear()
            etEdad.text.clear()
            etCiudad.text.clear()
            etCorreo.text.clear()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)

        btnContinuar.setOnClickListener {
            lanzarActividadResumen()
        }
    }

    /**
     * Valida los datos, crea un objeto Usuario y lanza ResumenActivity esperando un resultado.
     */
    private fun lanzarActividadResumen() {
        val nombre = etNombre.text.toString()
        val edad = etEdad.text.toString()
        val ciudad = etCiudad.text.toString()
        val correo = etCorreo.text.toString()

        if (nombre.isBlank() || edad.isBlank() || ciudad.isBlank() || correo.isBlank()) {
            Toast.makeText(this, getString(R.string.error_campos_vacios), Toast.LENGTH_SHORT).show()
            return
        }

        val usuario = Usuario(nombre, edad, ciudad, correo)

        val intent = Intent(this, ResumenActivity::class.java).apply {
            putExtra(ResumenActivity.EXTRA_USUARIO, usuario) //
        }

        resumenActivityResultLauncher.launch(intent)
    }

    /**
     * Guarda el estado de los campos de texto si la actividad se destruye (ej. por rotación). [cite: 22]
     * @param outState Bundle donde se guardará el estado.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NOMBRE, etNombre.text.toString())
        outState.putString(KEY_EDAD, etEdad.text.toString())
        outState.putString(KEY_CIUDAD, etCiudad.text.toString())
        outState.putString(KEY_CORREO, etCorreo.text.toString())
    }

    /**
     * Restaura el estado guardado previamente después de que la actividad se recrea.
     * @param savedInstanceState El Bundle que contiene el estado guardado.
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        etNombre.setText(savedInstanceState.getString(KEY_NOMBRE))
        etEdad.setText(savedInstanceState.getString(KEY_EDAD))
        etCiudad.setText(savedInstanceState.getString(KEY_CIUDAD))
        etCorreo.setText(savedInstanceState.getString(KEY_CORREO))
    }
}
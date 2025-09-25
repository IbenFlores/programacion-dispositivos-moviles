package com.example.practicacomunicacion

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * Descripción: Muestra un resumen del perfil y permite confirmar o volver a editar.
 * Autor: Iben Flores Polanco
 * Fecha creación: 25/09/2025
 * Fecha última modificación: 25/09/2025
 */
class ResumenActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USUARIO = "extra_usuario"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val tvNombre: TextView = findViewById(R.id.tvNombre)
        val tvEdad: TextView = findViewById(R.id.tvEdad)
        val tvCiudad: TextView = findViewById(R.id.tvCiudad)
        val tvCorreo: TextView = findViewById(R.id.tvCorreo)
        val btnConfirmar: Button = findViewById(R.id.btnConfirmar)
        val btnVolverEditar: Button = findViewById(R.id.btnVolverEditar)

        val usuario = obtenerUsuarioDelIntent()

        usuario?.let {
            tvNombre.text = getString(R.string.label_nombre) + " ${it.nombre}"
            tvEdad.text = getString(R.string.label_edad) + " ${it.edad}"
            tvCiudad.text = getString(R.string.label_ciudad) + " ${it.ciudad}"
            tvCorreo.text = getString(R.string.label_correo) + " ${it.correo}"
        }

        btnConfirmar.setOnClickListener {
            setResult(Activity.RESULT_OK) // [cite: 21]
            finish()
        }

        btnVolverEditar.setOnClickListener { // [cite: 18]
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    /**
     * Obtiene de forma segura el objeto Usuario desde los extras del Intent.
     * @return Un objeto Usuario, o null si no se encontró.
     */
    private fun obtenerUsuarioDelIntent(): Usuario? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_USUARIO, Usuario::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(EXTRA_USUARIO) as? Usuario
        }
    }
}
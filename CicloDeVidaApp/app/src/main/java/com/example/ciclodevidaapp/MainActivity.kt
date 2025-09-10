package com.example.ciclodevidaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private lateinit var textViewContador: TextView

    // 1. La Activity se está creando por primera vez.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos las vistas de la interfaz [cite: 7]
        textViewContador = findViewById(R.id.textViewContador)
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)

        // Configuramos el listener para el botón
        btnAumentar.setOnClickListener {
            contador++ // Aumentamos el contador
            textViewContador.text = "Contador: $contador" // Actualizamos el texto
        }

        // Mostramos que el método fue llamado
        Log.d("CICLO", "onCreate() llamado")
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
    }

    // 2. La Activity está a punto de hacerse visible.
    override fun onStart() {
        super.onStart()
        Log.d("CICLO", "onStart() llamado")
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()
    }

    // 3. La Activity es visible y el usuario puede interactuar con ella.
    override fun onResume() {
        super.onResume()
        Log.d("CICLO", "onResume() llamado")
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
    }

    // 4. Otra Activity toma el foco, pero esta sigue parcialmente visible.
    override fun onPause() {
        super.onPause()
        Log.d("CICLO", "onPause() llamado")
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
    }

    // 5. La Activity ya no es visible para el usuario.
    override fun onStop() {
        super.onStop()
        Log.d("CICLO", "onStop() llamado")
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
    }

    // Se llama antes de que la Activity sea destruida (ej. al rotar la pantalla).
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardamos el valor actual del contador en el Bundle [cite: 12, 62]
        outState.putInt("CONTADOR", contador)
        Log.d("CICLO", "onSaveInstanceState() llamado - Contador guardado: $contador")
        Toast.makeText(this, "onSaveInstanceState()", Toast.LENGTH_SHORT).show()
    }

    // Se llama después de onStart() si la Activity se está recreando.
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Recuperamos el valor del contador del Bundle [cite: 13, 64]
        contador = savedInstanceState.getInt("CONTADOR", 0) // El 0 es un valor por defecto
        textViewContador.text = "Contador: $contador"
        Log.d("CICLO", "onRestoreInstanceState() llamado - Contador restaurado: $contador")
        Toast.makeText(this, "onRestoreInstanceState()", Toast.LENGTH_SHORT).show()
    }

    // 6. La Activity está a punto de ser destruida.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("CICLO", "onDestroy() llamado")
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
    }
}
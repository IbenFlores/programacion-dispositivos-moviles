/**
 * Descripción corta: Reproductor de música básico con controles de reproducción, pausa y detención.
 * Autor: Iben Omar Flores Polanco
 * Fecha creación: 09/09/2025
 * Fecha última modificación: 09/09/2025
 */
package com.example.practica3_ejercicio2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar MediaPlayer con el archivo de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.musica)

        // Obtener las referencias a los botones
        val playButton: Button = findViewById(R.id.playButton)
        val pauseButton: Button = findViewById(R.id.pauseButton)
        val stopButton: Button = findViewById(R.id.stopButton)

        // Configurar el OnClickListener para el botón de Reproducir
        playButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start() // Iniciar la reproducción
            }
        }

        // Configurar el OnClickListener para el botón de Pausar
        pauseButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause() // Pausar la reproducción
            }
        }

        // Configurar el OnClickListener para el botón de Detener
        stopButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop() // Detener la reproducción
                // Es necesario preparar el MediaPlayer para volver a usarlo
                mediaPlayer.prepare()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberar los recursos del MediaPlayer cuando la actividad se destruye
        mediaPlayer.release()
    }
}
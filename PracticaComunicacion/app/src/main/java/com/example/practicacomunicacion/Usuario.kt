package com.example.practicacomunicacion

import java.io.Serializable

/**
 * Descripción: Modela el perfil de un usuario.
 * Autor: Iben Flores Polanco
 * Fecha creación: 25/09/2025
 * Fecha última modificación: 25/09/2025
 */
data class Usuario(
    val nombre: String,
    val edad: String,
    val ciudad: String,
    val correo: String
) : Serializable
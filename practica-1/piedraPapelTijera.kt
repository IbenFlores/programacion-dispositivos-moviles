/**
 * Descripción: Simula el juego de Piedra, Papel o Tijera contra la computadora.
 * Autor: Iben Omar Flores Polanco
 * Fecha de creación: 25/08/2025
 * Fecha de última modificación: 25/08/2025
 */

fun jugarPiedraPapelTijera() {
    val opciones = listOf("piedra", "papel", "tijera")
    val eleccionComputadora = opciones.random()

    println("Piedra, Papel o Tijera")
    print("Elige una opción (piedra, papel, tijera): ")
    val eleccionUsuario = readLine()?.lowercase()

    if (eleccionUsuario == null || eleccionUsuario !in opciones) {
        println("Opción no válida. Por favor, elige piedra, papel o tijera.")
        return
    }
    
    println("La computadora eligió: $eleccionComputadora")
    println("Tú elegiste: $eleccionUsuario")

    val resultado = determinarGanador(eleccionUsuario, eleccionComputadora)
    println("Resultado: $resultado")
}

fun determinarGanador(usuario: String, computadora: String): String {
    return when {
        usuario == computadora -> "Es un empate!"
        (usuario == "piedra" && computadora == "tijera") ||
        (usuario == "papel" && computadora == "piedra") ||
        (usuario == "tijera" && computadora == "papel") -> "Ganaste!"
        else -> "Perdiste!"
    }
}

fun main() {
    jugarPiedraPapelTijera()
}
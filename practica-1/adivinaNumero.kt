/**
 * Descripción: Juego de adivinar un número aleatorio entre 1 y 30 con 5 intentos.
 * Autor: Iben Omar Flores Polanco
 * Fecha de creación: 25/08/2025
 * Fecha de última modificación: 25/08/2025
 */

fun juegoAdivinaNumero() {
    val numeroSecreto = (1..30).random()
    val intentosMaximos = 5
    var intentosRealizados = 0
    var adivinado = false

    println("Adivina el Número Secreto (1-30)")
    println("Tienes $intentosMaximos intentos para adivinar el número.")

    while (intentosRealizados < intentosMaximos && !adivinado) {
        intentosRealizados++
        print("\nIntento $intentosRealizados: Introduce tu número: ")
        val numeroUsuario = readLine()?.toIntOrNull()

        if (numeroUsuario == null) {
            println("Entrada inválida. Inténtalo de nuevo.")
            continue
        }
        
        adivinado = evaluarIntento(numeroUsuario, numeroSecreto)
    }

    if (!adivinado) {
        println("\nSe te acabaron los intentos. El número era $numeroSecreto.")
    }
}

fun evaluarIntento(intento: Int, secreto: Int): Boolean {
    return when {
        intento == secreto -> {
            println("Felicidades! Has adivinado el número!")
            true
        }
        intento < secreto -> {
            println("El número secreto es MAYOR.")
            false
        }
        else -> {
            println("El número secreto es MENOR.")
            false
        }
    }
}

fun main() {
    juegoAdivinaNumero()
}
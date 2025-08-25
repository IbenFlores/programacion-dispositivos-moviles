/**
 * Descripción: Una calculadora básica que realiza sumas, restas, multiplicaciones y divisiones.
 * Autor: Iben Omar Flores Polanco
 * Fecha de creación: 25/08/2025
 * Fecha de última modificación: 25/08/2025
 */

fun mostrarMenu() {
    println("\nCalculadora")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicacion")
    println("4. Division")
    println("5. Salir")
    print("Elige una opcion: ")
}

fun realizarCalculo(opcion: Int) {
    if (opcion !in 1..4) {
        println("Opción no valida.")
        return
    }

    print("Introduce el primer numero: ")
    val num1 = readLine()?.toDoubleOrNull() ?: 0.0
    print("Introduce el segundo numero: ")
    val num2 = readLine()?.toDoubleOrNull() ?: 0.0

    val resultado = when (opcion) {
        1 -> "Resultado: ${num1 + num2}"
        2 -> "Resultado: ${num1 - num2}"
        3 -> "Resultado: ${num1 * num2}"
        4 -> if (num2 != 0.0) "Resultado: ${num1 / num2}" else "Error: No se puede dividir por cero."
        else -> "Opción inválida"
    }
    println(resultado)
}

fun main() {
    var opcion: Int

    do {
        mostrarMenu()
        opcion = readLine()?.toIntOrNull() ?: 0

        if (opcion in 1..4) {
            realizarCalculo(opcion)
        } else if (opcion == 5) {
            println("Saliendo...")
        } else {
            println("Por favor, introduce una opción válida del menú.")
        }
    } while (opcion != 5)
}
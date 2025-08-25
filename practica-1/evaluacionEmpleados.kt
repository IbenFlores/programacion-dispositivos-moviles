/**
 * Descripción: Evalúa el rendimiento de un empleado y calcula su bonificación.
 * Autor: Iben Omar Flores Polanco
 * Fecha de creación: 25/08/2025
 * Fecha de última modificación: 25/08/2025
 */

fun evaluarEmpleado(puntuacion: Int, salario: Double): Pair<String, Double> {
    val nivel: String
    val dinero: Double

    when (puntuacion) {
        in 0..3 -> {
            nivel = "Inaceptable"
        }
        in 4..6 -> {
            nivel = "Aceptable"
        }
        in 7..10 -> {
            nivel = "Meritorio"
        }
        else -> {
            nivel = "Puntuación inválida"
        }
    }

    dinero = if (nivel != "Puntuación inválida") {
        salario * (puntuacion / 10.0)
    } else {
        0.0
    }

    return Pair(nivel, dinero)
}

fun main() {
    println("Evaluación de Empleados")
    print("Introduce tu puntuación (0-10): ")
    val puntuacion = readLine()?.toIntOrNull() ?: 0

    print("Introduce tu salario mensual: ")
    val salario = readLine()?.toDoubleOrNull() ?: 0.0

    if (puntuacion in 0..10 && salario > 0) {
        val (nivel, dinero) = evaluarEmpleado(puntuacion, salario)
        println("\nResultado:")
        println("Nivel de Rendimiento: $nivel")
        println("Cantidad de Dinero Recibido: $$dinero")
    } else {
        println("\nError: Por favor, introduce una puntuación válida (0-10) y un salario positivo.")
    }
}
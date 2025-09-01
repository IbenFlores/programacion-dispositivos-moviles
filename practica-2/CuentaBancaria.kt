/**
 * Descripción: Clase que simula una cuenta bancaria con validaciones de saldo y límite de retiro.
 * Autor: Iben Omar Flores Polanco
 * Fecha de creación: 01/09/2025
 * Fecha de última modificación: 01/09/2025
 */

class CuentaBancaria(var limiteRetiro: Double) {
    var saldo: Double = 0.0
        // Getter personalizado que devuelve el valor del saldo.
        get() = field
        // Setter personalizado para validar el nuevo saldo.
        set(valor) {
            if (valor < 0) {
                println("Error: No se puede establecer un saldo negativo. Se establecerá en 0.")
                field = 0.0
            } else {
                field = valor
            }
        }

    fun retirar(monto: Double) {
        println("\nIntentando retirar $${monto}...")
        when {
            monto <= 0 -> println("Error: El monto a retirar debe ser positivo.")
            monto > limiteRetiro -> println("Error: El monto excede el límite de retiro de $${limiteRetiro}.")
            monto > saldo -> println("Error: Saldo insuficiente. Saldo actual: $${saldo}.")
            else -> {
                saldo -= monto
                println("Retiro exitoso. Nuevo saldo: $${saldo}.")
            }
        }
    }

    fun mostrarEstado() {
        println("--- Estado de la Cuenta ---")
        println("Saldo actual: $${saldo}")
        println("Límite de retiro: $${limiteRetiro}")
        println("-------------------------")
    }
}

fun main() {
    // Crear una instancia de CuentaBancaria
    val miCuenta = CuentaBancaria(limiteRetiro = 1000.0)
    
    // Establecer y mostrar saldo inicial
    miCuenta.saldo = 5000.0
    miCuenta.mostrarEstado()

    // Intentar establecer un saldo negativo (se activará la validación del 'set')
    println("\nIntentando establecer saldo negativo...")
    miCuenta.saldo = -200.0
    println("Saldo después del intento: $${miCuenta.saldo}")

    // Realizar operaciones de retiro
    miCuenta.saldo = 2500.0 // Re-establecemos un saldo para las pruebas
    miCuenta.retirar(500.0)    // Retiro exitoso
    miCuenta.retirar(1200.0)   // Excede el límite
    miCuenta.retirar(3000.0)   // Saldo insuficiente
    miCuenta.retirar(-100.0)   // Monto inválido

    // Mostrar estado final
    miCuenta.mostrarEstado()
}
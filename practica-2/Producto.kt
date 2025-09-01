/**
 * Descripción: Clase que representa un producto, calcula su precio final con descuento y valida sus datos.
 * Autor: Iben Omar Flores Polanco
 * Fecha de creación: 01/09/2025
 * Fecha de última modificación: 01/09/2025
 */

class Producto {
    var precio: Double = 0.0
        get() = field
        set(valor) {
            if (valor < 0) {
                println("Error: El precio no puede ser negativo. Se establecerá en 0.0.")
                field = 0.0
            } else {
                field = valor
            }
        }

    var descuento: Double = 0.0
        get() = field
        set(valor) {
            if (valor < 0 || valor > 100) {
                println("Error: El descuento debe estar entre 0 y 100. Se establecerá en 0.0.")
                field = 0.0
            } else {
                field = valor
            }
        }

    fun calcularPrecioFinal(): Double {
        val montoDescuento = precio * (descuento / 100.0)
        return precio - montoDescuento
    }
}

fun main() {
    val producto = Producto()

    println("--- Configurando producto válido ---")
    producto.precio = 150.0
    producto.descuento = 25.0 // 25% de descuento
    println("Producto configurado con Precio: $${producto.precio} y Descuento: ${producto.descuento}%")
    println("Precio final calculado: $${producto.calcularPrecioFinal()}")

    println("\n--- Intentando configurar precio inválido ---")
    producto.precio = -50.0
    println("Precio actual del producto: $${producto.precio}")

    println("\n--- Intentando configurar descuento inválido ---")
    producto.descuento = 120.0
    println("Descuento actual del producto: ${producto.descuento}%")
    
    println("\nPrecio final con valores corregidos: $${producto.calcularPrecioFinal()}")
}
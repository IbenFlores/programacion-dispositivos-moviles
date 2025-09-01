/**
 * Descripción: Implementación de una jerarquía de clases para figuras geométricas (cuadrado, círculo, rectángulo).
 * Autor: Iben Omar Flores Polanco
 * Fecha de creación: 01/09/2025
 * Fecha de última modificación: 01/09/2025
 */
import kotlin.math.PI

// Clase base abstracta
abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    fun calcularArea() {
        println("El área es: $area")
    }

    fun calcularPerimetro() {
        println("El perímetro es: $perimetro")
    }
}

// Subclase Cuadrado
class Cuadrado(private val lado: Double) : Shape() {
    // Constructor secundario como se solicitó
    constructor(valorLado: Int) : this(valorLado.toDouble())

    override val area: Double
        get() = lado * lado
    override val perimetro: Double
        get() = 4 * lado
}

// Subclase Círculo
class Circulo(private val radio: Double) : Shape() {
    // Constructor secundario
    constructor(valorRadio: Int) : this(valorRadio.toDouble())

    override val area: Double
        get() = PI * radio * radio
    override val perimetro: Double
        get() = 2 * PI * radio
}

// Subclase Rectángulo
class Rectangulo(private val base: Double, private val altura: Double) : Shape() {
    // Constructor secundario
    constructor(valorBase: Int, valorAltura: Int) : this(valorBase.toDouble(), valorAltura.toDouble())
    
    override val area: Double
        get() = base * altura
    override val perimetro: Double
        get() = 2 * base + 2 * altura
}

fun main() {
    println("--- Cuadrado ---")
    val miCuadrado = Cuadrado(lado = 5.0)
    miCuadrado.calcularArea()
    miCuadrado.calcularPerimetro()
    
    println("\n--- Círculo ---")
    val miCirculo = Circulo(10) // Usando el constructor secundario
    miCirculo.calcularArea()
    miCirculo.calcularPerimetro()

    println("\n--- Rectángulo ---")
    val miRectangulo = Rectangulo(base = 4.0, altura = 6.0)
    miRectangulo.calcularArea()
    miRectangulo.calcularPerimetro()
}
/**
 * Descripción: Sistema de gestión para una biblioteca que maneja materiales, usuarios y préstamos.
 * Autor: Iben Omar Flores Polanco
 * Fecha de creación: 01/09/2025
 * Fecha de última modificación: 01/09/2025
 */

// --- Clases Base e Interfaces ---

abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, tituloMaterial: String)
    fun devolverMaterial(usuario: Usuario, tituloMaterial: String)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesPrestadosPorUsuario(usuario: Usuario)
}

// --- Subclases de Material ---

class Libro(
    titulo: String, autor: String, anioPublicacion: Int,
    val genero: String, val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("--- Libro ---")
        println("Título: $titulo, Autor: $autor, Año: $anioPublicacion")
        println("Género: $genero, Páginas: $numeroPaginas")
    }
}

class Revista(
    titulo: String, autor: String, anioPublicacion: Int,
    val issn: String, val volumen: Int, val numero: Int, val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("--- Revista ---")
        println("Título: $titulo, Autor: $autor, Año: $anioPublicacion")
        println("Editorial: $editorial, ISSN: $issn, Vol: $volumen, Núm: $numero")
    }
}

// --- Clase de Datos para Usuario ---

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// --- Clase Principal de la Biblioteca ---

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material '${material.titulo}' registrado exitosamente.")
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (!prestamos.containsKey(usuario)) {
            prestamos[usuario] = mutableListOf()
            println("Usuario '${usuario.nombre} ${usuario.apellido}' registrado exitosamente.")
        } else {
            println("El usuario ya está registrado.")
        }
    }

    override fun prestarMaterial(usuario: Usuario, tituloMaterial: String) {
        val material = materialesDisponibles.find { it.titulo.equals(tituloMaterial, ignoreCase = true) }
        val listaUsuario = prestamos[usuario]

        when {
            listaUsuario == null -> println("Error: Usuario no registrado.")
            material == null -> println("Error: Material no disponible o no existe.")
            else -> {
                materialesDisponibles.remove(material)
                listaUsuario.add(material)
                println("'${material.titulo}' prestado a ${usuario.nombre}.")
            }
        }
    }

    override fun devolverMaterial(usuario: Usuario, tituloMaterial: String) {
        val listaUsuario = prestamos[usuario]
        val material = listaUsuario?.find { it.titulo.equals(tituloMaterial, ignoreCase = true) }

        when {
            listaUsuario == null -> println("Error: Usuario no registrado.")
            material == null -> println("Error: El usuario no tiene prestado este material.")
            else -> {
                listaUsuario.remove(material)
                materialesDisponibles.add(material)
                println("'${material.titulo}' devuelto por ${usuario.nombre}.")
            }
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("\n=== MATERIALES DISPONIBLES (${materialesDisponibles.size}) ===")
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles en este momento.")
        } else {
            materialesDisponibles.forEach { it.mostrarDetalles() }
        }
    }

    override fun mostrarMaterialesPrestadosPorUsuario(usuario: Usuario) {
        val listaUsuario = prestamos[usuario]
        println("\n=== MATERIALES PRESTADOS A ${usuario.nombre.uppercase()} (${listaUsuario?.size ?: 0}) ===")
        if (listaUsuario == null || listaUsuario.isEmpty()) {
            println("${usuario.nombre} no tiene materiales prestados.")
        } else {
            listaUsuario.forEach { it.mostrarDetalles() }
        }
    }
}

fun main() {
    // Inicializar sistema
    val biblioteca = Biblioteca()

    // Registrar materiales
    val libro1 = Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, "Realismo Mágico", 417)
    val revista1 = Revista("National Geographic", "Varios", 2025, "0027-9358", 248, 3, "National Geographic Society")
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)

    // Registrar usuarios
    val usuario1 = Usuario("Ana", "Torres", 30)
    val usuario2 = Usuario("Luis", "Vega", 25)
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)
    
    // Mostrar estado inicial
    biblioteca.mostrarMaterialesDisponibles()
    
    // Realizar un préstamo
    println("\n--- Realizando Préstamo ---")
    biblioteca.prestarMaterial(usuario1, "Cien Años de Soledad")
    
    // Mostrar estado después del préstamo
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesPrestadosPorUsuario(usuario1)
    biblioteca.mostrarMaterialesPrestadosPorUsuario(usuario2)
    
    // Realizar una devolución
    println("\n--- Realizando Devolución ---")
    biblioteca.devolverMaterial(usuario1, "Cien Años de Soledad")
    
    // Mostrar estado final
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesPrestadosPorUsuario(usuario1)
}
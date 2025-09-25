# Práctica 4: Comunicación entre Actividades

Este proyecto contiene dos pequeños ejercicios que demuestran las buenas prácticas para la comunicación entre Actividades en Android usando Kotlin. El enfoque principal es el uso de `Intent` para pasar datos y `registerForActivityResult` para recibir resultados.

## Ejercicios

### A. Editor de Perfil
- **FormularioActivity:** Una pantalla donde el usuario puede ingresar su nombre, edad, ciudad y correo electrónico.
- **ResumenActivity:** Una pantalla que muestra los datos del perfil para su confirmación.
- **Funcionalidades:**
    - Pasar un objeto personalizado `Usuario` (Serializable) entre actividades.
    - Devolver un resultado (`OK` o `CANCELED`) a la actividad anterior.
    - Guardar y restaurar el estado del formulario durante la rotación de la pantalla (`onSaveInstanceState`).

### B. Editor de Nota Rápida
- **EditorActivity:** Una pantalla simple con un campo de texto para escribir una nota.
- **OpcionesActivity:** Una pantalla que muestra la nota y ofrece opciones.
- **Funcionalidades:**
    - Pasar un `String` simple entre actividades.
    - Devolver el texto de la nota a la pantalla del editor para seguir modificándolo.
    - Guardar y restaurar el texto de la nota durante la rotación de la pantalla.

## Requisitos Técnicos
- [cite_start]Lenguaje: **Kotlin**  en Android Studio.
- [cite_start]**No se utilizan Fragments**[cite: 2], según los requisitos.
- Todas las cadenas de texto están definidas en `res/values/strings.xml`.
- El código incluye comentarios que explican el propósito de las funciones y sus parámetros.
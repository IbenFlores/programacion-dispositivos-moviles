package com.example.navegacionpedidos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * Descripción: Pantalla de inicio con un botón para comenzar un nuevo pedido.
 * Autor: Iben Flores Polanco
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */
class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)
        val btnNuevoPedido: Button = view.findViewById(R.id.btnNuevoPedido)

        btnNuevoPedido.setOnClickListener {
            [cite_start]// Navega a SeleccionComidaFragment usando la acción definida en nav_graph.xml. [cite: 9]
            findNavController().navigate(R.id.action_inicioFragment_to_seleccionComidaFragment)
        }

        return view
    }
}
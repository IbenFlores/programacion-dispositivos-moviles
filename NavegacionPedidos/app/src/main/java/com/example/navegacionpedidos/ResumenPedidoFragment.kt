package com.example.navegacionpedidos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

/**
 * Descripción: Muestra el resumen del pedido y permite confirmar o editar.
 * Autor: Iben Flores Polanco
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */
class ResumenPedidoFragment : Fragment() {

    private val args: ResumenPedidoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resumen_pedido, container, false)
        val tvResumenComida: TextView = view.findViewById(R.id.tvResumenComida)
        val tvResumenExtras: TextView = view.findViewById(R.id.tvResumenExtras)
        val btnConfirmar: Button = view.findViewById(R.id.btnConfirmar)
        val btnEditar: Button = view.findViewById(R.id.btnEditar)

        tvResumenComida.text = args.comidaSeleccionada

        val extras = args.extrasSeleccionados
        tvResumenExtras.text = if (extras.isNotEmpty()) extras else getString(R.string.sin_extras)

        btnConfirmar.setOnClickListener {
            Toast.makeText(context, getString(R.string.pedido_confirmado), Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_resumenPedidoFragment_to_inicioFragment)
        }

        btnEditar.setOnClickListener {
            val result = bundleOf(
                "comida" to args.comidaSeleccionada,
                "extras" to args.extrasSeleccionados
            )
            setFragmentResult("requestKey", result)
            findNavController().popBackStack()
        }

        return view
    }
}
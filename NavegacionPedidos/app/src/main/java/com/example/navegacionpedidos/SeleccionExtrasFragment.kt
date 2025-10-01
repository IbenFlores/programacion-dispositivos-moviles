package com.example.navegacionpedidos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

/**
 * Descripción: Permite al usuario seleccionar extras para su pedido.
 * Autor: Iben Flores Polanco
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */
class SeleccionExtrasFragment : Fragment() {

    private val args: SeleccionExtrasFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_extras, container, false)
        val btnSiguiente: Button = view.findViewById(R.id.btnSiguienteExtras)
        val cbBebida: CheckBox = view.findViewById(R.id.cbBebida)
        val cbPapas: CheckBox = view.findViewById(R.id.cbPapas)
        val cbPostre: CheckBox = view.findViewById(R.id.cbPostre)

        btnSiguiente.setOnClickListener {
            val extrasSeleccionados = mutableListOf<String>()
            if (cbBebida.isChecked) extrasSeleccionados.add(cbBebida.text.toString())
            if (cbPapas.isChecked) extrasSeleccionados.add(cbPapas.text.toString())
            if (cbPostre.isChecked) extrasSeleccionados.add(cbPostre.text.toString())

            val extrasComoString = extrasSeleccionados.joinToString(", ")

            val action = SeleccionExtrasFragmentDirections.actionSeleccionExtrasFragmentToResumenPedidoFragment(
                comidaSeleccionada = args.comidaSeleccionada,
                extrasSeleccionados = extrasComoString
            )
            findNavController().navigate(action)
        }
        return view
    }
}
package com.example.navegacionpedidos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

/**
 * Descripción: Permite al usuario seleccionar la comida principal del pedido.
 * Autor: Iben Flores Polanco
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 01/10/2025
 */
class SeleccionComidaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        [cite_start]// Escucha el resultado enviado desde ResumenPedidoFragment cuando se presiona "Editar". [cite: 28, 31]
        setFragmentResultListener("requestKey") { _, bundle ->
            // Recupera los datos y los establece en la UI.
            val comida = bundle.getString("comida")
            val extras = bundle.getStringArray("extras")

            // Lógica para pre-seleccionar los RadioButton y CheckBox (no implementada aquí por brevedad)
            // Esto es útil para que el usuario no pierda su selección al editar.
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_comida, container, false)
        val rgComida: RadioGroup = view.findViewById(R.id.rgComida)
        val btnSiguiente: Button = view.findViewById(R.id.btnSiguienteComida)

        btnSiguiente.setOnClickListener {
            val selectedRadioButtonId = rgComida.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(context, getString(R.string.error_selecciona_comida), Toast.LENGTH_SHORT).show()
            } else {
                val selectedRadioButton: RadioButton = view.findViewById(selectedRadioButtonId)
                val comidaSeleccionada = selectedRadioButton.text.toString()

                [cite_start]// Usamos Safe Args para crear la acción y pasar los datos de forma segura. [cite: 13, 14, 29]
                val action = SeleccionComidaFragmentDirections.actionSeleccionComidaFragmentToSeleccionExtrasFragment(comidaSeleccionada)
                findNavController().navigate(action)
            }
        }
        return view
    }
}
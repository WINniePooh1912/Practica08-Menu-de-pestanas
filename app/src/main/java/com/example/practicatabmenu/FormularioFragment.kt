package com.example.practicatabmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast

class FormularioFragment : Fragment() {
    private lateinit var view: View
    private lateinit var comentario : EditText
    private lateinit var correo : EditText
    private lateinit var estrellas : RatingBar
    private lateinit var enviar : Button
    private var numEstrellas : Float = 0.0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_formulario, container, false)

        comentario = view.findViewById(R.id.edtComentario)
        correo = view.findViewById(R.id.edtCorreo)
        estrellas = view.findViewById(R.id.rbEstrellas)
        enviar = view.findViewById(R.id.btnEnviar)

        estrellas.numStars = 5
        estrellas.setOnRatingBarChangeListener { estrellas, rating, fromUser -> numEstrellas = rating  }

        enviar!!.setOnClickListener {
            val servicio = when {
                numEstrellas <= 2.0 -> "Mal servicio"
                numEstrellas in 3.0..4.0 -> "Buen servicio"
                else -> "Excelente servicio"
            }

            Toast.makeText(context, "Tu comentario fue ${comentario.text} con $numEstrellas, lo consideras un $servicio", Toast.LENGTH_SHORT).show()

            correo.text = null
            comentario.text = null
            correo.requestFocus()
        }
        return view
    }
}
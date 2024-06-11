package com.example.aplicacinmovil

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Inf_ConvActivity: AppCompatActivity() {

    private lateinit var database: DatabaseReference

    private lateinit var editTextTiempo: EditText
    private lateinit var editTextTiempoSolo: EditText
    private lateinit var editTextNiños: EditText
    private lateinit var editTextActiv: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inf_adop_viv)

        database = FirebaseDatabase.getInstance().reference

        editTextTiempo = findViewById(R.id.textTiempo)
        editTextTiempoSolo = findViewById(R.id.textHoras)
        editTextNiños = findViewById(R.id.textNiños)
        editTextActiv = findViewById(R.id.textActiv)

        val buttonFin: Button = findViewById(R.id.buttonFin)
        buttonFin.setOnClickListener {
            guardarDatos()
        }
    }

    private fun guardarDatos() {

        val tiempo = editTextTiempo.text.toString()
        val tiemposolo = editTextTiempoSolo.text.toString()
        val niños = editTextNiños.text.toString()
        val actividades = editTextActiv.text.toString()

        if (tiempo.isEmpty() || tiemposolo.isEmpty() || niños.isEmpty() || actividades.isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val data = mapOf(
            "tiempo" to tiempo,
            "tiemposolo" to tiemposolo,
            "niños" to niños,
            "actividades" to actividades
        )

        // Generaramos una clave única para los registros
        val dataId = database.push().key
        if (dataId != null) {
            // Guardar los datos en la base de datos
            database.child("convadoptante").child(dataId).setValue(data)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showAlert("El registro fue exitoso")
                    } else {
                        Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
        }
    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("")
        builder.setMessage("El registro fue exitoso")
        builder.setPositiveButton("Ok") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}
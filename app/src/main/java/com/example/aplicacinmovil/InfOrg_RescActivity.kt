package com.example.aplicacinmovil

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InfOrg_RescActivity: AppCompatActivity() {

    private lateinit var database: DatabaseReference

    private lateinit var editTextNameOrg: EditText
    private lateinit var editTextNit: EditText
    private lateinit var editTextDireccion: EditText
    private lateinit var editTextURL: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resc_inf_org)

        database = FirebaseDatabase.getInstance().reference

        editTextNameOrg = findViewById(R.id.textNameOrg)
        editTextNit = findViewById(R.id.textNit)
        editTextDireccion = findViewById(R.id.textDireccion)
        editTextURL = findViewById(R.id.textURL)

        val buttonFin: Button = findViewById(R.id.buttonFinalizar)
        buttonFin.setOnClickListener{

            guardarDatos()

        }

    }

private fun guardarDatos() {

    val nameORG = editTextNameOrg.text.toString()
    val nit = editTextNit.text.toString()
    val direccion = editTextDireccion.text.toString()
    val url = editTextURL.text.toString()

    if (nameORG.isEmpty() || nit.isEmpty() || direccion.isEmpty() || url.isEmpty()) {
        Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
        return
    }

    val data = mapOf(
        "nameOrg" to nameORG,
        "nit" to nit,
        "direccion" to direccion,
        "url" to url
    )

    // Generaramos una clave única para los registros
    val dataId = database.push().key
    if (dataId != null) {
        // Guardar los datos en la base de datos
        database.child("rescatistaOrg").child(dataId).setValue(data)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showAlert("El registro fue exitoso")
                } else {
                    Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
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
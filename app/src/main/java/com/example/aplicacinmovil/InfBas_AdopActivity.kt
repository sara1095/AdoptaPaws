package com.example.aplicacinmovil

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InfBas_AdopActivity: AppCompatActivity() {

    private lateinit var database: DatabaseReference

    private lateinit var editTextName: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextCelular: EditText
    private lateinit var editTextBarrio: EditText
    private lateinit var editTextContacto: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infbas_adop)

        database = FirebaseDatabase.getInstance().reference

        editTextName = findViewById(R.id.textNameAdop)
        editTextCorreo = findViewById(R.id.textCorreoAdop)
        editTextCelular = findViewById(R.id.textCelularAdop)
        editTextBarrio = findViewById(R.id.textBarrioAdop)
        editTextContacto = findViewById(R.id.textContacto)

        val buttonContinuar: Button = findViewById(R.id.buttonContinuar)
        buttonContinuar.setOnClickListener {

            guardarDatos()

        }
    }
    private fun guardarDatos() {

        val name = editTextName.text.toString()
        val correo = editTextCorreo.text.toString()
        val celular = editTextCelular.text.toString()
        val barrio = editTextBarrio.text.toString()
        val contacto = editTextContacto.text.toString()

        if (name.isEmpty() || correo.isEmpty() || celular.isEmpty() || barrio.isEmpty() || contacto.isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val data = mapOf(
            "name" to name,
            "correo" to correo,
            "celular" to celular,
            "barrio" to barrio,
            "contacto" to contacto
        )

        // Generamos una clave única para los registros
        val dataId = database.push().key
        if (dataId != null) {
            // Guardar los datos en la base de datos
            database.child("adoptante").child(dataId).setValue(data)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        redirectToAnotherActivity()
                    } else {
                        Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
    private fun redirectToAnotherActivity() {
        val intent = Intent(this, Inf_ConvActivity::class.java)
        startActivity(intent)
        finish()
    }
}
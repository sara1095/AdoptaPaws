package com.example.aplicacinmovil

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class InfOrg_RescActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resc_inf_org)

        val buttonFin: Button = findViewById(R.id.buttonFinalizar)
        buttonFin.setOnClickListener{
                showAlert();
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("")
        builder.setMessage("El registro fue exitoso")
        builder.setPositiveButton("Ok"){dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}
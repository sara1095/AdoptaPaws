package com.example.aplicacinmovil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectAdopActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_adop)

        val buttonPerro: Button = findViewById(R.id.buttonPerro)
        buttonPerro.setOnClickListener{
            val intent = Intent(this, InfBas_AdopActivity::class.java)
            startActivity(intent)

        val buttonGato: Button = findViewById(R.id.buttonGato)
        buttonGato.setOnClickListener {
            val intent1 = Intent(this, InfBas_AdopActivity::class.java)
            startActivity(intent1)

            }
        }
    }
}
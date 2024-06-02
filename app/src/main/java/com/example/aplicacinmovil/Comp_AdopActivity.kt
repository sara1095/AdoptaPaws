package com.example.aplicacinmovil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Comp_AdopActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comp_adop)

        val buttonContinuar: Button = findViewById(R.id.buttonContinuar)
        buttonContinuar.setOnClickListener {
            val intent = Intent(this, Comp_Adop2Activity::class.java)
            startActivity(intent)
        }
    }
}
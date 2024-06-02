package com.example.aplicacinmovil

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Comp_Adop2Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comp_adop2)

        val buttonContinuar: Button = findViewById(R.id.buttonContinuar)
        buttonContinuar.setOnClickListener(){
            val intent = Intent(this, Inf_ConvActivity::class.java)
            startActivity(intent)
        }
    }
}
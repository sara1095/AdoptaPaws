package com.example.aplicacinmovil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        val buttonAdop: Button = findViewById(R.id.buttonAdoptar)
        buttonAdop.setOnClickListener {
            val intent = Intent(this, SelectAdopActivity::class.java)
            startActivity(intent)

            val buttonDarenAdop: Button = findViewById(R.id.buttonDarenAdopcion)
            buttonDarenAdop.setOnClickListener {
                val intent2 = Intent(this, InfBas_RescActivity::class.java)
                startActivity(intent2)
            }
        }
    }
}
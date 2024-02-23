package dev.encuestas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val btnListaOpciones = findViewById<Button>(R.id.btnListaOpciones)
        btnListaOpciones.setOnClickListener {
            navigatoToListaOne() }



    }

    fun navigatoToListaOne() {
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)

    }
}
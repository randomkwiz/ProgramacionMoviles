package es.iesnervion.avazquez.primeraplicacionkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    var txtResultado: TextView ? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonEnviar = findViewById<Button> (R.id.btnEnviar)
        txtResultado = findViewById(R.id.resultado)
        botonEnviar.setOnClickListener(this);

    }

    override fun onClick(v: View?) {
        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextApellidos = findViewById<EditText>(R.id.editTextApellidos)

        txtResultado?.setText("Hola ${editTextNombre.text} ${editTextApellidos.text}")
    }
}

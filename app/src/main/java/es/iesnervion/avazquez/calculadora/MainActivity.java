package es.iesnervion.avazquez.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity

{

    EditText cajaDigitos;
    Button sumar;
    Button restar;
    Button dividir;
    Button multiplicar;
    Button igual;
    Button modulo;
    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaDigitos = findViewById(R.id.editTextNumbers);
    }

    public void sumar (View v){
        /*Angela repiensa el diseño mejor*/
    }

}

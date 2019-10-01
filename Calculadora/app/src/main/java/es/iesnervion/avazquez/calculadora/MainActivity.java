package es.iesnervion.avazquez.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener
{

    EditText cajaDigitos;
    Button sumar;
    Button restar;
    Button dividir;
    Button multiplicar;
    Button igual;
    Button modulo;
    Button cero;
    Button uno;
    Button dos;
    Button tres;
    Button cuatro;
    Button cinco;
    Button seis;
    Button siete;
    Button ocho;
    Button nueve;
    boolean hayQueLimpiar;

    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hayQueLimpiar = false;
        cajaDigitos = findViewById(R.id.editTextNumbers);
        sumar = findViewById(R.id.suma);
        restar = findViewById(R.id.resta);
        dividir = findViewById(R.id.division);
        multiplicar = findViewById( R.id.multiplicacion);
        modulo = findViewById(R.id.resto);
        igual = findViewById(R.id.igual);
        cero = findViewById(R.id.numeroCero);
        uno = findViewById(R.id.numeroUno);
        dos = findViewById(R.id.numeroDos);
        tres = findViewById(R.id.numeroTres);
        cuatro = findViewById(R.id.numeroCuatro);
        cinco = findViewById(R.id.numeroCinco);
        seis = findViewById(R.id.numeroSeis);
        siete = findViewById(R.id.numeroSiete);
        ocho  = findViewById(R.id.numeroOcho);
        nueve = findViewById(R.id.numeroNueve);


        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        dividir.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        modulo.setOnClickListener(this);
        igual.setOnClickListener(this);
        cero.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.numeroCero:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("0");
                break;
            case R.id.numeroUno:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("1");
                break;
            case R.id.numeroDos:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("2");
                break;
            case R.id.numeroTres:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("3");
                break;
            case R.id.numeroCuatro:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("4");
                break;
            case R.id.numeroCinco:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("5");
                break;
            case R.id.numeroSeis:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("6");
                break;
            case R.id.numeroSiete:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("7");
                break;
            case R.id.numeroOcho:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("8");
                break;
            case R.id.numeroNueve:

                if(hayQueLimpiar){
                    cajaDigitos.setText("");
                    hayQueLimpiar = false;
                }
                cajaDigitos.append("9");
                break;

            case R.id.suma:
                resultado += Double.parseDouble(cajaDigitos.getText().toString());
                //cajaDigitos.setText(Double.toString(resultado));
                hayQueLimpiar = true;
                break;
            case R.id.resta:
                resultado = resultado - Double.parseDouble(cajaDigitos.getText().toString());
                //cajaDigitos.setText(Double.toString(resultado));
                hayQueLimpiar = true;
                break;

            case R.id.igual:
                hayQueLimpiar = true;
                cajaDigitos.setText(Double.toString(resultado));
                break;

        }
    }
}

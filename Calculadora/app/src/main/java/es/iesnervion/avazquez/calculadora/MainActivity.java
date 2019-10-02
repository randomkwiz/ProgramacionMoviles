package es.iesnervion.avazquez.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

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
    Button limpiar;
    TextView registro;


    Double numeroUno = null;
    Double numeroDos = null;
    Double resultado;
    int idOperador ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaDigitos = findViewById(R.id.editTextNumbers);
        sumar = findViewById(R.id.suma);
        restar = findViewById(R.id.resta);
        dividir = findViewById(R.id.division);
        multiplicar = findViewById(R.id.multiplicacion);
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
        ocho = findViewById(R.id.numeroOcho);
        nueve = findViewById(R.id.numeroNueve);
        limpiar = findViewById(R.id.limpiar);
        registro = findViewById(R.id.registro);
        idOperador = 0;

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
        limpiar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (numeroUno != null && !cajaDigitos.getText().equals("")) {
            igual.setEnabled(true);
        }
        switch (v.getId()) {
            case R.id.numeroCero:
                cajaDigitos.append("0");
                break;
            case R.id.numeroUno:
                cajaDigitos.append("1");
                break;
            case R.id.numeroDos:
                cajaDigitos.append("2");
                break;
            case R.id.numeroTres:
                cajaDigitos.append("3");

                break;
            case R.id.numeroCuatro:
                cajaDigitos.append("4");

                break;
            case R.id.numeroCinco:
                cajaDigitos.append("5");

                break;
            case R.id.numeroSeis:
                cajaDigitos.append("6");

                break;
            case R.id.numeroSiete:
                cajaDigitos.append("7");

                break;
            case R.id.numeroOcho:
                cajaDigitos.append("8");

                break;
            case R.id.numeroNueve:
                cajaDigitos.append("9");
                break;
            case R.id.suma:
            case R.id.resta:
            case R.id.division:
            case R.id.multiplicacion:
            case R.id.resto:
                escribirNumeroEnRegistro(asignarNumeroCorrespondiente());
                limpiar();
                idOperador = v.getId();
                break;
            case R.id.igual:
                escribirNumeroEnRegistro(asignarNumeroCorrespondiente());
                limpiar();
                resultado = calcular(numeroUno, numeroDos);
                cajaDigitos.setText(String.valueOf(resultado));
                setEnabledBotonesOperadores(false);
                setEnabledBotonesNumericos(false);
                igual.setEnabled(false);
                escribirNumeroEnRegistro(resultado);
                break;
            case R.id.limpiar:
                limpiar();
                setEnabledBotonesOperadores(true);
                setEnabledBotonesNumericos(true);
                igual.setEnabled(true);
                numeroUno = null;
                numeroDos = null;
                break;
        }
    }

    private void escribirNumeroEnRegistro(double numero) {
        registro.setText(Double.toString(numero));
    }

    private void limpiar() {
        cajaDigitos.setText("");
    }

    private double calcular(Double numeroUno, Double numeroDos) {
        double res = 5;
        switch (idOperador) {
            case R.id.suma:
                res = numeroUno + numeroDos;
                break;
            case R.id.resta:
                res = numeroUno - numeroDos;
                break;
            case R.id.division:
                res = numeroUno / numeroDos;
                break;
            case R.id.multiplicacion:
                res = numeroUno * numeroDos;
                break;
            case R.id.resto:
                res = numeroUno % numeroDos;
                break;
        }

        return res;
    }


    /*Para habilitar / deshabilitar todos los botones*/
    public void setEnabledBotonesOperadores(boolean enabled) {
        if (enabled) {
            restar.setEnabled(true);
            sumar.setEnabled(true);
            dividir.setEnabled(true);
            multiplicar.setEnabled(true);
            modulo.setEnabled(true);
        } else {
            restar.setEnabled(false);
            sumar.setEnabled(false);
            dividir.setEnabled(false);
            multiplicar.setEnabled(false);
            modulo.setEnabled(false);
        }
    }

    public void setEnabledBotonesNumericos(boolean enabled) {
        if (enabled) {
            cero.setEnabled(true);
            uno.setEnabled(true);
            dos.setEnabled(true);
            tres.setEnabled(true);
            cuatro.setEnabled(true);
            cinco.setEnabled(true);
            seis.setEnabled(true);
            siete.setEnabled(true);
            ocho.setEnabled(true);
            nueve.setEnabled(true);

        } else {
            cero.setEnabled(false);
            uno.setEnabled(false);
            dos.setEnabled(false);
            tres.setEnabled(false);
            cuatro.setEnabled(false);
            cinco.setEnabled(false);
            seis.setEnabled(false);
            siete.setEnabled(false);
            ocho.setEnabled(false);
            nueve.setEnabled(false);
        }
    }

    public double asignarNumeroCorrespondiente() {
        double numero = 0;
        if (numeroUno == null && numeroDos == null) {
            numeroUno = Double.parseDouble(cajaDigitos.getText().toString());
            setEnabledBotonesOperadores(false);
            igual.setEnabled(false);
            numero = numeroUno;

        } else if (numeroUno != null && numeroDos == null) {
            numeroDos = Double.parseDouble(cajaDigitos.getText().toString());
            igual.setEnabled(true);
            numero = numeroDos;
        }
        return numero;
    }

}

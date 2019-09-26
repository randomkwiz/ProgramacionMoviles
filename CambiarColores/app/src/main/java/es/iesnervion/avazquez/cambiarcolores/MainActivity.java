package es.iesnervion.avazquez.cambiarcolores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener
{

    Button botonAzul;
    Button botonRojo;
    Button botonVerde;
    Button botonAmarillo;
    Button reset;
    TextView fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fondo = findViewById(R.id.fondo);
        reset = findViewById(R.id.reset);
        botonAmarillo = findViewById(R.id.botonAmarillo);
        botonAzul = findViewById(R.id.botonAzul);
        botonRojo = findViewById(R.id.botonRojo);
        botonVerde = findViewById(R.id.botonVerde);

        botonAmarillo.setOnClickListener(this);
        botonVerde.setOnClickListener(this);
        botonRojo.setOnClickListener(this);
        botonAzul.setOnClickListener(this);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.botonAmarillo:
                v.setBackgroundColor(Color.parseColor("#F3F781"));
                fondo.setBackgroundColor(Color.parseColor("#F3F781"));
                break;
            case R.id.botonAzul:
                v.setBackgroundColor(Color.parseColor("#A9F5F2"));
                fondo.setBackgroundColor(Color.parseColor("#A9F5F2"));
                break;
            case R.id.botonRojo:
                v.setBackgroundColor(Color.parseColor("#F5A9A9"));
                fondo.setBackgroundColor(Color.parseColor("#F5A9A9"));
                break;
            case R.id.botonVerde:
                v.setBackgroundColor(Color.parseColor("#9FF781"));
                fondo.setBackgroundColor(Color.parseColor("#9FF781"));
                break;
            case R.id.reset:
                botonAzul.setBackgroundResource(android.R.drawable.btn_default);
                botonRojo.setBackgroundResource(android.R.drawable.btn_default);
                botonVerde.setBackgroundResource(android.R.drawable.btn_default);
                botonAmarillo.setBackgroundResource(android.R.drawable.btn_default);
                fondo.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;

        }

    }
}

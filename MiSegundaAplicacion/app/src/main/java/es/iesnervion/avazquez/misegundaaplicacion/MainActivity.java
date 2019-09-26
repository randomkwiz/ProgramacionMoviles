package es.iesnervion.avazquez.misegundaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener
{

    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.botonHorario);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        actualizar();

    }

    public void actualizar(){
        btn.setText(new Date().toString());
    }
}

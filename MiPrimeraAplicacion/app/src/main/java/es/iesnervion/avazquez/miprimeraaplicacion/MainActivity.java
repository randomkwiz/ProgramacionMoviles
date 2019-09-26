package es.iesnervion.avazquez.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void actualizar(View v){
        Button btn = (Button) findViewById(R.id.miboton);
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Date fecha = Calendar.getInstance().getTime();
        String s = formato.format(fecha);
        btn.setText(s);

    }

}

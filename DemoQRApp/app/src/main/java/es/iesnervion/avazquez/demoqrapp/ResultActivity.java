package es.iesnervion.avazquez.demoqrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.resultados)
    TextView resultados;

    @BindView(R.id.ScanBtn)
    Button scanBtn;
    ResultViewModel viewModel;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        viewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        sharedPreferences = getSharedPreferences("ResultadosPreguntas", Context.MODE_PRIVATE);



        resultados.setText("Preguntas de respuesta única acertadas: ");
        resultados.append(String.valueOf(sharedPreferences.getInt("basicQA_correct", 0)));
        resultados.append("\n");
        resultados.append("Preguntas de respuesta única falladas: ");
        resultados.append(String.valueOf(sharedPreferences.getInt("basicQA_failed", 0)));


        resultados.append("\n");

        resultados.append("Preguntas de respuesta única con imágenes acertadas: ");
        resultados.append(String.valueOf(sharedPreferences.getInt("imgQA_correct", 0)));
        resultados.append("\n");
        resultados.append("Preguntas de respuesta única con imágenes  falladas: ");
        resultados.append(String.valueOf(sharedPreferences.getInt("imgQA_failed", 0)));

        scanBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ScanBtn:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}

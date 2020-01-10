package es.iesnervion.avazquez.sharedpreferencespiedrapapeltijeras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton piedra;
    ImageButton papel;
    ImageButton tijeras;
    int resultadoJuego;
    SharedPreferences sharedPreferences;
    TextView resultados;
    Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        piedra = findViewById(R.id.rock);
        papel = findViewById(R.id.paper);
        tijeras = findViewById(R.id.scissors);
        resultados = findViewById(R.id.resultado);
        btnReset = findViewById(R.id.btnReset);

        piedra.setOnClickListener(this);
        papel.setOnClickListener(this);
        tijeras.setOnClickListener(this);
        btnReset.setOnClickListener(this);



        sharedPreferences = getSharedPreferences("ResultadosJuego", Context.MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        Util util = new Util();
        String eleccionMaquina = util.randomGame();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(view.getId() == R.id.btnReset){
            editor.putInt("VictoriasMaquina", 0);
            editor.putInt("Empates", 0);
            editor.putInt("VictoriasJugador", 0);
            resultados.setText("");

        }else{
            /*Añadimos esa informacion al archivo*/

            resultados.setText("La maquina ha elegido: " + eleccionMaquina);
            resultados.append("\n");
            resultados.append("El jugador ha elegido: ");
        /*
            -1 -gana la maquina
            0 - empate
            1 - gana el jugador
        */
            switch (view.getId()){
                case R.id.rock:
                    resultadoJuego = util.evalGame(eleccionMaquina, "rock");
                    resultados.append("rock");
                    break;
                case R.id.paper:
                    resultadoJuego = util.evalGame(eleccionMaquina, "paper");
                    resultados.append("paper");

                    break;
                case R.id.scissors:
                    resultadoJuego = util.evalGame(eleccionMaquina, "scissors");
                    resultados.append("scissors");

                    break;
            }
            resultados.append("\n");
            sharedPreferences = getSharedPreferences("ResultadosJuego", Context.MODE_PRIVATE);

            int victoriasMaquina = sharedPreferences.getInt("VictoriasMaquina", 0);
            int victoriasJugador = sharedPreferences.getInt("VictoriasJugador", 0);
            int empates = sharedPreferences.getInt("Empates", 0);
            switch (resultadoJuego){
                case -1:
                    editor.putInt("VictoriasMaquina", ++victoriasMaquina);

                    break;
                case 0:
                    editor.putInt("Empates", ++empates);
                    break;
                case 1:
                    editor.putInt("VictoriasJugador", ++victoriasJugador);
                    break;
            }

        }

        editor.commit();
        publicarGanador();
    }

    /*Hago esto para probar el shared preferences*/

    public void publicarGanador(){
        sharedPreferences = getSharedPreferences("ResultadosJuego", Context.MODE_PRIVATE);

        int victoriasMaquina = sharedPreferences.getInt("VictoriasMaquina", 0);
        int victoriasJugador = sharedPreferences.getInt("VictoriasJugador", 0);
        int empates = sharedPreferences.getInt("Empates", 0);

        resultados.append("Victorias de la máquina: " + victoriasMaquina);
        resultados.append("\n");
        resultados.append("Victorias del jugador: " + victoriasJugador);
        resultados.append("\n");
        resultados.append("Empates: " + empates);

    }
}

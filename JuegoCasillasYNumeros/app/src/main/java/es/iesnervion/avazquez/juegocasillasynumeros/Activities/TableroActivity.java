package es.iesnervion.avazquez.juegocasillasynumeros.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import es.iesnervion.avazquez.juegocasillasynumeros.R;
import es.iesnervion.avazquez.juegocasillasynumeros.ViewModel.TableroViewModel;

public class TableroActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        Intent mIntent = getIntent();
        int lado = mIntent.getIntExtra("lado",0);

        ConstraintLayout layout = findViewById(R.id.layout);
        TableroViewModel viewModel = new TableroViewModel (getApplication(), layout, lado);
        layout = viewModel.getLayout();

        colocarListeners(layout, lado, viewModel.getMapeo());


    }



    public void colocarListeners(ConstraintLayout layout, int lado, SparseIntArray mapeo){
        int contador = 0;
        for (int iRow = 0; iRow < lado; iRow++) {
            for (int iCol = 0; iCol < lado; iCol++) {

                contador ++;
                if(contador <= lado ){
                    //es la linea de las casillas horizontales

                }else if( (contador-1) % lado == 0){ //er gitaneo weno pa que me pille la primera casilla de cada fila
                    //es la linea de las casillas verticales

                }else{
                    //casillas jugables
                    int idABuscar = mapeo.get(contador);
                    ImageView view = findViewById(idABuscar);
                    view.setOnClickListener(this);
                }

            }
        }


    }

    @Override
    public void onClick(View v) {
        ImageView casilla = (ImageView) v;

        if((int)casilla.getTag() == R.drawable.selecteditem){
                casilla.setImageResource(R.drawable.nonselecteditem);
                casilla.setTag(null);
        }else{
            casilla.setImageResource(R.drawable.selecteditem);
            casilla.setTag(R.drawable.selecteditem);
        }

    }
}

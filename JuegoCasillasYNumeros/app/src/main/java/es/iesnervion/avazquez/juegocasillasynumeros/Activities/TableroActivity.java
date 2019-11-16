package es.iesnervion.avazquez.juegocasillasynumeros.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Tablero;
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
        colocarListeners(layout, viewModel.getTablero(), viewModel.getMapeo());
    }



    public void colocarListeners(ConstraintLayout layout, Tablero tablero, SparseIntArray mapeo){
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {

                if(tablero.getCasillas()[iRow][iCol].isJugable() )
                {
                    //Poner Listener
                    View view = layout.getViewById(tablero.getCasillas()[iRow][iCol].getId());
                    view.setOnClickListener(this);

                }





            }
        }


    }

    @Override
    public void onClick(View v) {
        ImageView casilla = (ImageView) v;

        //TODO no se como hacer esta parte orientada a objetos ya que solo recibo la vista
        //si quisiera hacerlo OO necesitaria la posicion y es un jaleo

        if((int)casilla.getTag() == R.drawable.selecteditem){
                casilla.setImageResource(R.drawable.nonselecteditem);
                casilla.setTag(R.drawable.nonselecteditem);
        }else{
            casilla.setImageResource(R.drawable.selecteditem);
            casilla.setTag(R.drawable.selecteditem);
        }



    }
}

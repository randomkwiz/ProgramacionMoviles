package es.iesnervion.avazquez.juegocasillasynumeros.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.ViewModelProviders;

import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Casilla;
import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Tablero;
import es.iesnervion.avazquez.juegocasillasynumeros.MyViewModelFactory;
import es.iesnervion.avazquez.juegocasillasynumeros.R;
import es.iesnervion.avazquez.juegocasillasynumeros.Utilidad.Utilidad;
import es.iesnervion.avazquez.juegocasillasynumeros.ViewModel.TableroViewModel;

public class TableroActivity extends AppCompatActivity implements View.OnClickListener {

    TableroViewModel viewModel;
    Button evaluateBtn;
    Button refreshBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        Intent mIntent = getIntent();
        int lado = mIntent.getIntExtra("lado",0);

        ConstraintLayout layout = findViewById(R.id.layout);
        evaluateBtn = findViewById(R.id.evaluateBtn);
        refreshBtn = findViewById(R.id.refreshBtn);

        View gridFrame = findViewById(R.id.gridFrame);

        //He tenido que hacer mi propio VM Factory pa pode pasarle parametros al VM
        viewModel = ViewModelProviders.of(this, new MyViewModelFactory(this.getApplication(),layout, lado, gridFrame)).
                get(TableroViewModel.class);

        int cantidadDeHijos = viewModel.getLayout().getChildCount();    //pal debugger



        //establecerTablero(viewModel.getLayout(),this,viewModel.getMapeo(),viewModel.getTablero());
        colocarListeners(viewModel.getLayout(), viewModel.getTablero(), viewModel.getMapeo());
        evaluateBtn.setOnClickListener(this);
        refreshBtn.setOnClickListener(this);

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

        if(v instanceof ImageView){
            ImageView casilla = (ImageView) v;
            Utilidad utilidad = new Utilidad();
            Casilla objetoCasilla = utilidad.obtenerCasillaPorID(viewModel.getTablero(),v.getId());
            //TODO no se como hacer esta parte orientada a objetos ya que solo recibo la vista
            //si quisiera hacerlo OO necesitaria la posicion y es un jaleo

            if((int)casilla.getTag() == R.drawable.selecteditem){
                casilla.setImageResource(R.drawable.nonselecteditem);
                casilla.setTag(R.drawable.nonselecteditem);


                //TODO haz un metodo que te devuelva la casilla por la ID y asi
                //tienes toda esta parte arreglada
                objetoCasilla.setMarcada(false);

            }else{
                casilla.setImageResource(R.drawable.selecteditem);
                casilla.setTag(R.drawable.selecteditem);
                objetoCasilla.setMarcada(true);
            }
        }else if(v instanceof Button){
            switch (v.getId()){
                case R.id.evaluateBtn:
                    Toast mensaje;
                    Utilidad utilidad = new Utilidad();
                    if(utilidad.comprobarSiLaSolucionEsCorrecta(viewModel.getLayout(), viewModel.getTablero())){
                        mensaje = Toast.makeText(getApplicationContext(),"¡BIEN!", Toast.LENGTH_SHORT);
                    }else{
                        mensaje = Toast.makeText(getApplicationContext(),"DALE UNA VUELTECITA BRO", Toast.LENGTH_SHORT);
                    }
                    mensaje.show();
                    break;
                case R.id.refreshBtn:
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Has pulsado Refresh", Toast.LENGTH_SHORT);
                    toast1.show();
                    break;
            }
        }


    }

    public void establecerTablero(ConstraintLayout layout, Context context, SparseIntArray mapeo, Tablero tablero){

        //lo he tenido que poner como view porque van a ser ImageView o TextView dependiendo de donde esten
        View view;
        ConstraintLayout.LayoutParams lp;
        int id ;
        int contador = 0;
        int idArray[][] = new int[tablero.getLado()][tablero.getLado()];    //lo necesito abajo
        ConstraintSet cs = new ConstraintSet();
        // Add our views to the ConstraintLayout.
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {

                lp = new ConstraintLayout.LayoutParams(ConstraintSet.MATCH_CONSTRAINT,
                        ConstraintSet.MATCH_CONSTRAINT);

                id = View.generateViewId();     //es unico por eso tenias el fallo de que se acumulaban (y es necesario tb)

                mapeo.append(contador, id); //sistema de clave- valor solo que ambos son int (pa este caso el SparseIntArray es mejor que el hash map)
                contador ++;

                tablero.getCasillas()[iRow][iCol].setId(id);
                idArray[iRow][iCol] = id;   //lo necesito abajo

                if(contador <= tablero.getLado() ){
                    view = new TextView(context);
                    ((TextView) view).setText(("H"));
                    //TODO colocar maximos horizontales y verticales
                    ((TextView) view).setGravity(Gravity.CENTER);
                    //Estas casillas son donde se ponen los numeros
                    tablero.getCasillas()[iRow][iCol].setJugable(false);

                }else if( (contador-1) % tablero.getLado() == 0){ //er gitaneo weno pa que me pille la primera casilla de cada fila
                    view = new TextView(context);
                    ((TextView)view).setText(("V"));
                    ((TextView) view).setGravity(Gravity.CENTER);
                    //Estas casillas son donde se ponen los numeros
                    tablero.getCasillas()[iRow][iCol].setJugable(false);
                }else{
                    view = new ImageView(context);
                    view.setPaddingRelative(10,10,10,10);
                    //Esta parte la querria hacer sin esto, solo usando los atributos isMarcada
                    //-> Ver metodo onClick para saber por que no lo hice asi
                    ((ImageView)view).setImageResource(R.drawable.nonselecteditem);
                    view.setTag(R.drawable.nonselecteditem);

                    //Estas casillas son donde se ponen las marcas
                    tablero.getCasillas()[iRow][iCol].setJugable(true);

                }
                view.setId(id);
                view.setBackgroundResource(R.drawable.border_shape);

                layout.addView(view, lp);
            }
        }

        // Create horizontal chain for each row and set the 1:1 dimensions.
        // but first make sure the layout frame has the right ratio set.
        cs.clone(layout);
        cs.setDimensionRatio(R.id.gridFrame, tablero.getLado() + ":" + tablero.getLado());
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {
                id = tablero.getCasillas()[iRow][iCol].getId();
                cs.setDimensionRatio(id, "1:1");
                if (iRow == 0) {
                    // Connect the top row to the top of the frame.
                    cs.connect(id, ConstraintSet.TOP, R.id.gridFrame, ConstraintSet.TOP);
                } else {
                    // Connect top to bottom of row above.
                    cs.connect(id, ConstraintSet.TOP, tablero.getCasillas()[iRow - 1][0].getId(), ConstraintSet.BOTTOM);
                }
            }
            // Create a horiontal chain that will determine the dimensions of our squares.
            // Could also be createHorizontalChainRtl() with START/END.
            cs.createHorizontalChain(R.id.gridFrame, ConstraintSet.LEFT,
                    R.id.gridFrame, ConstraintSet.RIGHT,
                    idArray[iRow], null, ConstraintSet.CHAIN_PACKED);
        }

        cs.applyTo(layout);

    }
}

package es.iesnervion.avazquez.juegocasillasynumeros.ViewModel;


import android.app.Application;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.ViewModel;

import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Tablero;
import es.iesnervion.avazquez.juegocasillasynumeros.R;
import es.iesnervion.avazquez.juegocasillasynumeros.Utilidad.Utilidad;


public class TableroViewModel extends ViewModel {

    private ConstraintLayout layout ;
    private View gridFrame;

    private Tablero tablero;
    private SparseIntArray mapeo = new SparseIntArray();
    private Context context;

    public TableroViewModel(Application application, ConstraintLayout layout,int lado, View gridFrame) {
        this.context = application.getBaseContext();
        this.layout = layout;
        this.tablero = new Tablero(lado);
        this.gridFrame = gridFrame;
        //establecerTablero();
        Utilidad utilidad = new Utilidad();
        utilidad.establecerTablero(layout,context,mapeo,tablero);
        utilidad.establecerMarcasEnTablero(tablero);
        utilidad.establecerNumeroDeMarcasHorizontalesYVerticales(tablero);
        utilidad.escribirNumerosEnLayout(layout,tablero);


    }

    public ConstraintLayout getLayout() {

        return layout;
    }

    public void setLayout(ConstraintLayout layout) {
        this.layout = layout;
    }



    public SparseIntArray getMapeo() {
        return mapeo;
    }

    public void setMapeo(SparseIntArray mapeo) {
        this.mapeo = mapeo;
    }

    public Tablero getTablero() {
        return tablero;
    }



    public void establecerTablero(){

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
        //cs.setDimensionRatio(R.id.gridFrame, tablero.getLado() + ":" + tablero.getLado());
        cs.setDimensionRatio(gridFrame.getId(), tablero.getLado() + ":" + tablero.getLado());
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {
                id = tablero.getCasillas()[iRow][iCol].getId();
                cs.setDimensionRatio(id, "1:1");
                if (iRow == 0) {
                    // Connect the top row to the top of the frame.
                    cs.connect(id, ConstraintSet.TOP, gridFrame.getId(), ConstraintSet.TOP);
                } else {
                    // Connect top to bottom of row above.
                    cs.connect(id, ConstraintSet.TOP, tablero.getCasillas()[iRow - 1][0].getId(), ConstraintSet.BOTTOM);
                }
            }
            // Create a horiontal chain that will determine the dimensions of our squares.
            // Could also be createHorizontalChainRtl() with START/END.
            cs.createHorizontalChain(gridFrame.getId(), ConstraintSet.LEFT,
                    gridFrame.getId(), ConstraintSet.RIGHT,
                    idArray[iRow], null, ConstraintSet.CHAIN_PACKED);
        }

        cs.applyTo(layout);

    }

}

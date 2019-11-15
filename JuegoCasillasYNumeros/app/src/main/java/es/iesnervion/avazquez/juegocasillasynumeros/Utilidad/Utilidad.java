package es.iesnervion.avazquez.juegocasillasynumeros.Utilidad;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import es.iesnervion.avazquez.juegocasillasynumeros.R;



public class Utilidad {

    public void establecerTablero(ConstraintLayout layout, int lado, Context context, SparseIntArray mapeo){

        //lo he tenido que poner como view porque van a ser ImageView o TextView dependiendo de donde esten
        View view;
        ConstraintLayout.LayoutParams lp;
        int id ;
        int contador = 0;
        int idArray[][] = new int[lado][lado];
        ConstraintSet cs = new ConstraintSet();

        // Add our views to the ConstraintLayout.
        for (int iRow = 0; iRow < lado; iRow++) {
            for (int iCol = 0; iCol < lado; iCol++) {

                lp = new ConstraintLayout.LayoutParams(ConstraintSet.MATCH_CONSTRAINT,
                        ConstraintSet.MATCH_CONSTRAINT);


                id = View.generateViewId();     //es unico por eso tenias el fallo de que se acumulaban (y es necesario tb)

                mapeo.append(contador, id);
                contador ++;
                idArray[iRow][iCol] = id;

                if(contador <= lado ){
                    view = new TextView(context);
                    ((TextView) view).setText(("H"));
                    ((TextView) view).setGravity(Gravity.CENTER);

                }else if( (contador-1) % lado == 0){ //er gitaneo weno pa que me pille la primera casilla de cada fila
                    view = new TextView(context);
                    ((TextView)view).setText(("V"));
                    ((TextView) view).setGravity(Gravity.CENTER);

                }else{
                    view = new ImageView(context);

                    view.setPaddingRelative(10,10,10,10);

                    //((ImageView)view).setImageResource(R.drawable.selecteditem);
                    //((ImageView)view).setTag(R.drawable.selecteditem);
                }
                view.setId(id);
                view.setBackgroundResource(R.drawable.border_shape);




                layout.addView(view, lp);
            }
        }

        // Create horizontal chain for each row and set the 1:1 dimensions.
        // but first make sure the layout frame has the right ratio set.
        cs.clone(layout);
        cs.setDimensionRatio(R.id.gridFrame, lado + ":" + lado);
        for (int iRow = 0; iRow < lado; iRow++) {
            for (int iCol = 0; iCol < lado; iCol++) {
                id = idArray[iRow][iCol];
                cs.setDimensionRatio(id, "1:1");
                if (iRow == 0) {
                    // Connect the top row to the top of the frame.
                    cs.connect(id, ConstraintSet.TOP, R.id.gridFrame, ConstraintSet.TOP);
                } else {
                    // Connect top to bottom of row above.
                    cs.connect(id, ConstraintSet.TOP, idArray[iRow - 1][0], ConstraintSet.BOTTOM);
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

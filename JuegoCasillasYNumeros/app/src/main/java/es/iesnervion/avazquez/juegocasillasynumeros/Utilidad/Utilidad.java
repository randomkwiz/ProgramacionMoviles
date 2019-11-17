package es.iesnervion.avazquez.juegocasillasynumeros.Utilidad;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.ViewModel;

import java.util.Random;

import es.iesnervion.avazquez.juegocasillasynumeros.Activities.TableroActivity;
import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Casilla;
import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Tablero;
import es.iesnervion.avazquez.juegocasillasynumeros.R;



public class Utilidad {

    public void establecerTablero(ConstraintLayout layout, Context context, SparseIntArray mapeo, Tablero tablero){

        //lo he tenido que poner como view porque van a ser ImageView o TextView dependiendo de donde esten
        View view;
        ConstraintLayout.LayoutParams lp;
        int id ;
        int contador = 0;
        int contadorRow = 0;
        int contadorCol = 0;
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
                    ((TextView) view).setTextColor(Color.BLACK);
                    ((TextView) view).setGravity(Gravity.CENTER);
                    //Estas casillas son donde se ponen los numeros
                    tablero.getCasillas()[iRow][iCol].setJugable(false);

                }else if( (contador-1) % tablero.getLado() == 0){ //er gitaneo weno pa que me pille la primera casilla de cada fila
                    view = new TextView(context);

                    ((TextView) view).setTextColor(Color.BLACK);



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

    /*
    Establece las marcas horizontales y verticales
     */

    public void establecerNumeroDeMarcasHorizontalesYVerticales(Tablero tablero){
        int[] row = new int[tablero.getMarcasHorizontales().length];
        int[] col= new int[tablero.getMarcasVerticales().length];
        int contadorRow = 0;
        int contadorCol = 0;
        int indice = 0;

        for(int iCol = 1; iCol < tablero.getLado(); iCol++){
            for(int iRow = 1; iRow < tablero.getLado(); iRow++ ){
                if(tablero.getCasillas()[iCol][iRow].isJugable() &&
                        tablero.getCasillas()[iCol][iRow].isMarcada()
                ){
                  contadorCol++;
                }
            }
            col[indice] = contadorCol;
            contadorCol = 0;
            indice++;
        }


        indice = 0;
        //Ahora igual pero al reves (no cambio el nombre de iRow <-> iCol por pereza
        for(int iRow = 1; iRow< tablero.getLado(); iRow++){
            for(int iCol = 1; iCol< tablero.getLado(); iCol++ ){
                if(tablero.getCasillas()[iCol][iRow].isJugable() &&
                        tablero.getCasillas()[iCol][iRow].isMarcada()
                ){
                    contadorRow++;
                }
            }
            row[indice] = contadorRow;
            contadorRow = 0;
            indice++;
        }




        tablero.setMarcasHorizontales(col);
        tablero.setMarcasVerticales(row);
    }


    /*Deja las marcas en el tablero (lo hago asi simplemente para luego hacer recuento
    y asegurarme que el juego con numeros que pongo se puede hacer
    */
    public void establecerMarcasEnTablero(Tablero tablero) {
        for (int iCol = 1; iCol < tablero.getLado(); iCol++) {
            for (int iRow = 1; iRow < tablero.getLado(); iRow++) {

                if(tablero.getCasillas()[iCol][iRow].isJugable()){
                    if(marcoONoMarco()){
                        tablero.getCasillas()[iCol][iRow].setMarcada(true);
                    }
                }
            }
        }
    }


    /*Reinicia la partida*/
    public void refreshGame(Context context, Tablero tablero ){

        View view;

        int contador = 0;
        // Add our views to the ConstraintLayout.
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {
                 contador ++;
                if(contador <= tablero.getLado() ){
                    view = new TextView(context);
                    ((TextView)view).setText("");


                }else if( (contador-1) % tablero.getLado() == 0){ //er gitaneo weno pa que me pille la primera casilla de cada fila
                    view = new TextView(context);
                    ((TextView)view).setText("");

                }else{
                    view = new ImageView(context);
                    //Esta parte la querria hacer sin esto, solo usando los atributos isMarcada
                    //-> Ver metodo onClick para saber por que no lo hice asi
                    ((ImageView)view).setImageResource(R.drawable.nonselecteditem);
                    view.setTag(R.drawable.nonselecteditem);

                    //Estas casillas son donde se ponen las marcas
                    tablero.getCasillas()[iRow][iCol].setJugable(true);
                    tablero.getCasillas()[iRow][iCol].setMarcada(false);

                }
            }
        }
    }






    /*Random que decide si se marca o no una casilla */
    private boolean marcoONoMarco(){
        final int MAX = 2;
        int numeroAleatorio = (int) (Math.random()* MAX+1);
        boolean marcar = false;
        if(numeroAleatorio == 1){
            marcar = true;
        }

        return marcar;
    }

    public Casilla obtenerCasillaPorID(Tablero tablero, int id){
        Casilla casilla = null;
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {

                if(tablero.getCasillas()[iRow][iCol].getId() == id){
                    casilla = tablero.getCasillas()[iRow][iCol];
                }
            }
        }
        return casilla;
    }



/*Escribe los numeros en el layout */
    public void escribirNumerosEnLayout(ConstraintLayout layout, Tablero tablero){

        //lo he tenido que poner como view porque van a ser ImageView o TextView dependiendo de donde esten
        View view;


        int contador = 0;
        int contadorRow = 0;
        int contadorCol = 0;


        // Add our views to the ConstraintLayout.
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {
               contador ++;

               if(iRow != 0 || iCol != 0){  //para que no escriba justo en la posicion 0,0
                   if(!tablero.getCasillas()[iRow][iCol].isJugable()){
                       if(contador <= tablero.getLado() ){
                           view = layout.getViewById(tablero.getCasillas()[iRow][iCol].getId());
                           ((TextView)view).setText(String.valueOf(tablero.getMarcasHorizontales()[contadorCol]));
                           //((TextView)view).setText("H");
                            contadorCol ++;

                           ((TextView) view).setTextColor(Color.BLACK);
                           ((TextView) view).setGravity(Gravity.CENTER);

                       }else if( (contador-1) % tablero.getLado() == 0){
                           view = layout.getViewById(tablero.getCasillas()[iRow][iCol].getId());

                           ((TextView) view).setTextColor(Color.BLACK);
                           ((TextView)view).setText(String.valueOf(tablero.getMarcasVerticales()[contadorRow]));
                            contadorRow++;

                       }
                   }
               }




            }
        }


    }



        /*Evalua si la solucion del usuario es correcta*/
    public boolean comprobarSiLaSolucionEsCorrecta(ConstraintLayout layout,Tablero tablero){
        boolean isCorrectCol = false;
        boolean isCorrectRow = false;
        boolean isCorrecto = true;

        for(int i = 1; i < tablero.getLado() ; i ++){
            isCorrectCol = comprobarColumnaCorrecta(layout,tablero,i);
            isCorrectRow = comprobarFilaCorrecta(layout,tablero,i);

            if(!isCorrectCol || !isCorrectRow){ //si alguna de las dos es incorrecta
                isCorrecto = false;
            }
        }

        return isCorrecto;
    }

    /*Comprueba las FILAS (comprobado)*/
    public boolean comprobarFilaCorrecta(ConstraintLayout layout,Tablero tablero, int nRow){
        boolean isCorrecta = false;
        int contadorRow = 0;


            for(int iCol = 1; iCol < tablero.getLado(); iCol++ ){
                if(tablero.getCasillas()[nRow][iCol].isJugable())
                {
                    //Cuento las marcas que hay en la columna "nCol"
                    if((int) layout.getViewById(tablero.getCasillas()[nRow][iCol].getId()).getTag() == R.drawable.selecteditem){
                        contadorRow++;
                    }

                }
            }
            //Si las marcas son las mismas que para su cabecera, esta columna esta correcta
            if(tablero.getMarcasVerticales()[nRow-1] == contadorRow){
                isCorrecta = true;
            }

        return isCorrecta;
    }


    /*Comprueba una fila*/
    public boolean comprobarColumnaCorrecta(ConstraintLayout layout,Tablero tablero, int nCol){
        boolean isCorrecta = false;
        int contadorCol = 0;
        int indice = 0;

        for(int iRow = 1; iRow< tablero.getLado(); iRow++ ){
            if(tablero.getCasillas()[iRow][nCol].isJugable())
            {
                //Cuento las marcas que hay en la fila "nRow"
                if((int) layout.getViewById(tablero.getCasillas()[iRow][nCol].getId()).getTag() == R.drawable.selecteditem){
                    contadorCol++;
                }

            }
        }
        //Si las marcas son las mismas que para su cabecera, esta fila esta correcta
        if(tablero.getMarcasHorizontales()[nCol-1] == contadorCol){
            isCorrecta = true;
        }

        return isCorrecta;
    }


    //Pone las marcas que hubiera, sirve pa que no se pierdan al rotar
    public void ponerMarcas(Tablero tablero, ConstraintLayout layout){
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {
                if(tablero.getCasillas()[iRow][iCol].isJugable()){
                    if(tablero.getCasillas()[iRow][iCol].isMarcada()){
                        //esta es la ImageView de la casilla
                        ((ImageView)layout.getViewById(tablero.getCasillas()[iRow][iCol].getId())).setImageResource(R.drawable.selecteditem);
                        ((ImageView)layout.getViewById(tablero.getCasillas()[iRow][iCol].getId())).setTag(R.drawable.selecteditem);

                    }else{
                        ((ImageView)layout.getViewById(tablero.getCasillas()[iRow][iCol].getId())).setImageResource(R.drawable.nonselecteditem);
                        ((ImageView)layout.getViewById(tablero.getCasillas()[iRow][iCol].getId())).setTag(R.drawable.nonselecteditem);
                    }
                }

            }
        }
    }





}

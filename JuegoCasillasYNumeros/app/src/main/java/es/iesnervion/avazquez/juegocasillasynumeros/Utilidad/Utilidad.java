package es.iesnervion.avazquez.juegocasillasynumeros.Utilidad;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Casilla;
import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Tablero;
import es.iesnervion.avazquez.juegocasillasynumeros.R;



public class Utilidad {


    public void establecerCasillasJugablesTablero(Tablero tablero){
        int contador = 0;   //cuenta el numero de casillas en general

        // Add our views to the ConstraintLayout.
        for (int iRow = 0; iRow < tablero.getLado(); iRow++) {
            for (int iCol = 0; iCol < tablero.getLado(); iCol++) {

                contador++;
                if(contador <= tablero.getLado() ){

                    //Estas casillas son donde se ponen los numeros
                    tablero.getCasillas()[iRow][iCol].setJugable(false);

                }else if( (contador-1) % tablero.getLado() == 0){ //er gitaneo weno pa que me pille la primera casilla de cada fila

                    //Estas casillas son donde se ponen los numeros
                    tablero.getCasillas()[iRow][iCol].setJugable(false);
                }else{

                    //Estas casillas son donde se ponen las marcas
                    tablero.getCasillas()[iRow][iCol].setJugable(true);

                }
            }
        }
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
    public boolean comprobarSiLaSolucionEsCorrecta(Tablero tablero){
        boolean isCorrectCol = false;
        boolean isCorrectRow = false;
        boolean isCorrecto = true;

        for(int i = 1; i < tablero.getLado() ; i ++){
            isCorrectCol = comprobarColumnaCorrecta(tablero,i);
            isCorrectRow = comprobarFilaCorrecta(tablero,i);

            if(!isCorrectCol || !isCorrectRow){ //si alguna de las dos es incorrecta
                isCorrecto = false;
            }
        }

        return isCorrecto;
    }

    /*Comprueba las FILAS (comprobado)*/
    public boolean comprobarFilaCorrecta(Tablero tablero, int nRow){
        boolean isCorrecta = false;
        int contadorRow = 0;


            for(int iCol = 1; iCol < tablero.getLado(); iCol++ ){
                if(tablero.getCasillas()[nRow][iCol].isJugable())
                {
                    //Cuento las marcas que hay en la columna "nCol"
                    if(tablero.getCasillas()[nRow][iCol].getImgSrc() == R.drawable.selecteditem){
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
    public boolean comprobarColumnaCorrecta(Tablero tablero, int nCol){
        boolean isCorrecta = false;
        int contadorCol = 0;


        for(int iRow = 1; iRow< tablero.getLado(); iRow++ ){
            if(tablero.getCasillas()[iRow][nCol].isJugable())
            {
                //Cuento las marcas que hay en la fila "nRow"
                if(tablero.getCasillas()[iRow][nCol].getImgSrc() == R.drawable.selecteditem){
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



}

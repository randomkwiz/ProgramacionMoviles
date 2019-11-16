package es.iesnervion.avazquez.juegocasillasynumeros.Clases;

public class Tablero {
    private int lado;
    Casilla[][] casillas;
    int[] marcasHorizontales;

    //asi hago los maximosVerticales una propiedad derivada, ya que solo tendria que sumar los
    //puntos colocados para los maximos horizontales

    public Tablero(int lado) {
        this.lado = lado;
        casillas = new Casilla[lado][lado];

        //inicializar array de casillas
        for (int iRow = 0; iRow <lado; iRow++) {
            for (int iCol = 0; iCol < lado; iCol++) {
                    casillas[iRow][iCol] = new Casilla();

            }}

                //colocar maximos horizontales
        //colocar maximos verticales

    }

    public int getLado() {
        return lado;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public int[] getMarcasHorizontales() {
        return marcasHorizontales;
    }

    public int[] getMarcasVerticales(){
        //TODO esto
        return null;
    }
}

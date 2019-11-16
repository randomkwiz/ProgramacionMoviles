package es.iesnervion.avazquez.juegocasillasynumeros.Clases;

public class Casilla {
    private boolean isJugable;
    private boolean isMarcada;
    private int id;
    private int numeroAMostrar;

    public Casilla(boolean isMarcada, int id) {
        this.isMarcada = isMarcada;
        this.id = id;
        this.isJugable = false;
        this.numeroAMostrar = 0;
    }

    public Casilla(boolean isMarcada) {
        this.isMarcada = isMarcada;
        this.id = -1;
        this.isJugable = false;
        this.numeroAMostrar = 0;
    }

    public Casilla() {
        this.isMarcada = false;
        this.id = -1;
        this.isJugable = false;
        this.numeroAMostrar = 0;
    }

    public boolean isMarcada() {
        return isMarcada;
    }

    public void setMarcada(boolean marcada) {
        isMarcada = marcada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isJugable() {
        return isJugable;
    }

    public void setJugable(boolean jugable) {
        isJugable = jugable;
    }

    public int getNumeroAMostrar() {
        return numeroAMostrar;
    }

    public void setNumeroAMostrar(int numeroAMostrar) {
        this.numeroAMostrar = numeroAMostrar;
    }
}

package es.iesnervion.avazquez.centroeducativo.entities;

import java.util.ArrayList;

public class Profesor extends Persona {
    private String asignaturaPrincipal;
    private ArrayList<String> asignaturasSecundarias;

    public Profesor() {
        super();
    }

    public Profesor(String asignaturaPrincipal, ArrayList<String> asignaturasSecundarias) {
        super();
        this.asignaturaPrincipal = asignaturaPrincipal;
        this.asignaturasSecundarias = asignaturasSecundarias;
    }

    public Profesor(String nombre, String apellido, int imgSrc, String asignaturaPrincipal) {
        super(nombre, apellido, imgSrc);
        this.asignaturaPrincipal = asignaturaPrincipal;
    }

    public Profesor(String nombre, String apellido, int imgSrc) {
        super(nombre, apellido, imgSrc);
    }

    public String getAsignaturaPrincipal() {
        return asignaturaPrincipal;
    }

    public void setAsignaturaPrincipal(String asignaturaPrincipal) {
        this.asignaturaPrincipal = asignaturaPrincipal;
    }

    public ArrayList<String> getAsignaturasSecundarias() {
        return asignaturasSecundarias;
    }

    public void setAsignaturasSecundarias(ArrayList<String> asignaturasSecundarias) {
        this.asignaturasSecundarias = asignaturasSecundarias;
    }
}

package es.iesnervion.avazquez.examenandroidroomfragments.room.entities;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Atleta {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre;
    private String apellido;
    private String observaciones;

    @Ignore
    public Atleta(int id, String nombre, String apellido, String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.observaciones = observaciones;
    }

    public Atleta() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.observaciones = "";
    }

    @Ignore
    public Atleta(String nombre, String apellido, String observaciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

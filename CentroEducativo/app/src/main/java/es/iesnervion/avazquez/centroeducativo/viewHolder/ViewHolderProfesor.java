package es.iesnervion.avazquez.centroeducativo.viewHolder;

import android.widget.ImageView;
import android.widget.TextView;


public class ViewHolderProfesor {

    ImageView fotoProfesor;
    TextView nombreProfesor;
    TextView asignaturaProfesor;

    public ViewHolderProfesor(ImageView fotoProfesor, TextView nombreProfesor, TextView asignaturaProfesor) {
        this.fotoProfesor = fotoProfesor;
        this.nombreProfesor = nombreProfesor;
        this.asignaturaProfesor = asignaturaProfesor;
    }

    public ImageView getFotoProfesor() {
        return fotoProfesor;
    }

    public void setFotoProfesor(ImageView fotoProfesor) {
        this.fotoProfesor = fotoProfesor;
    }

    public TextView getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(TextView nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public TextView getAsignaturaProfesor() {
        return asignaturaProfesor;
    }

    public void setAsignaturaProfesor(TextView asignaturaProfesor) {
        this.asignaturaProfesor = asignaturaProfesor;
    }
}

package es.iesnervion.avazquez.centroeducativo.viewHolder;


import android.widget.TextView;

public class ViewHolderAlumno {
    TextView nombreAlumno;

    public ViewHolderAlumno(TextView nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public TextView getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(TextView nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
}

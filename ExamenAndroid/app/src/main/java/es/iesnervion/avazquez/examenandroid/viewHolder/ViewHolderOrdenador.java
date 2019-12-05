package es.iesnervion.avazquez.examenandroid.viewHolder;

import android.widget.ImageView;
import android.widget.TextView;

//TODO idea para más adelante: podria hacerse un ViewHolder que tuviera los atributos comunes y luego heredar de ese, pero no lo he hecho nunca y no quiero experimentar en un examen pero estaría más limpio hecho de esa manera

public class ViewHolderOrdenador {

    private ImageView disponibilidad;
    private ImageView imgOrd;
    private TextView txtNombreOrd;
    private ImageView imgCPU;

    public ViewHolderOrdenador(ImageView disponibilidad, ImageView imgOrd, TextView txtNombreOrd, ImageView imgCPU) {
        this.disponibilidad = disponibilidad;
        this.imgOrd = imgOrd;
        this.txtNombreOrd = txtNombreOrd;
        this.imgCPU = imgCPU;
    }


    public ImageView getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(ImageView disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public ImageView getImgOrd() {
        return imgOrd;
    }

    public void setImgOrd(ImageView imgOrd) {
        this.imgOrd = imgOrd;
    }

    public TextView getTxtNombreOrd() {
        return txtNombreOrd;
    }

    public void setTxtNombreOrd(TextView txtNombreOrd) {
        this.txtNombreOrd = txtNombreOrd;
    }

    public ImageView getImgCPU() {
        return imgCPU;
    }

    public void setImgCPU(ImageView imgCPU) {
        this.imgCPU = imgCPU;
    }
}

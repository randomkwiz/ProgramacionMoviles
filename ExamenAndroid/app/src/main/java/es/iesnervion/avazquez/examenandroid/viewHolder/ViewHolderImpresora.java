package es.iesnervion.avazquez.examenandroid.viewHolder;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderImpresora {

    private ImageView disponibilidad;
    private ImageView imgImpr;
    private TextView txtNombreImpr;
    private TextView txtTipoImpr;

    public ViewHolderImpresora(ImageView disponibilidad, ImageView imgImpr, TextView txtNombreImpr, TextView txtTipoImpr) {
        this.disponibilidad = disponibilidad;
        this.imgImpr = imgImpr;
        this.txtNombreImpr = txtNombreImpr;
        this.txtTipoImpr = txtTipoImpr;
    }

    public ImageView getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(ImageView disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public ImageView getImgImpr() {
        return imgImpr;
    }

    public void setImgImpr(ImageView imgImpr) {
        this.imgImpr = imgImpr;
    }

    public TextView getTxtNombreImpr() {
        return txtNombreImpr;
    }

    public void setTxtNombreImpr(TextView txtNombreImpr) {
        this.txtNombreImpr = txtNombreImpr;
    }

    public TextView getTxtTipoImpr() {
        return txtTipoImpr;
    }

    public void setTxtTipoImpr(TextView txtTipoImpr) {
        this.txtTipoImpr = txtTipoImpr;
    }
}

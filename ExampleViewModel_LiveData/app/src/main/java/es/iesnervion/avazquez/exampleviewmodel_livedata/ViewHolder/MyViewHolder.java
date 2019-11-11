package es.iesnervion.avazquez.exampleviewmodel_livedata.ViewHolder;

import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder {
    ImageView imgRow;
    TextView txtRow;

    public MyViewHolder(ImageView imgRow, TextView txtRow) {
        this.imgRow = imgRow;
        this.txtRow = txtRow;
    }

    public ImageView getImgRow() {
        return imgRow;
    }

    public void setImgRow(ImageView imgRow) {
        this.imgRow = imgRow;
    }

    public TextView getTxtRow() {
        return txtRow;
    }

    public void setTxtRow(TextView txtRow) {
        this.txtRow = txtRow;
    }
}

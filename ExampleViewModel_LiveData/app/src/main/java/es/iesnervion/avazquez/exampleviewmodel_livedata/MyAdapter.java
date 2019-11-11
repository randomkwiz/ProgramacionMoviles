package es.iesnervion.avazquez.exampleviewmodel_livedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import es.iesnervion.avazquez.exampleviewmodel_livedata.ViewHolder.MyViewHolder;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> lista;

    public MyAdapter(Context context, ArrayList<String> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder viewHolder ;
        ImageView imgRow;
        TextView txtRow;

        //elemento actual
        String elemento = lista.get(position);

        if(convertView == null){
            //se infla
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_row, parent,false);

            imgRow = convertView.findViewById(R.id.imgRow);
            txtRow = convertView.findViewById(R.id.txtRow);
            viewHolder = new MyViewHolder(imgRow, txtRow);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (MyViewHolder) convertView.getTag();
        }

        viewHolder.getImgRow().setImageResource(R.drawable.java);   //de momento se queda asi
        viewHolder.getTxtRow().setText(elemento);

        return convertView;
    }
}

package es.iesnervion.avazquez.practicaspinneryautocomplete.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.avazquez.practicaspinneryautocomplete.Clases.AnimalImpl;
import es.iesnervion.avazquez.practicaspinneryautocomplete.R;
import es.iesnervion.avazquez.practicaspinneryautocomplete.ViewHolder;

public class AutoTextAdapter extends ArrayAdapter {

    Context context;
    ArrayList<AnimalImpl> listaAnimales;

    public AutoTextAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }


}

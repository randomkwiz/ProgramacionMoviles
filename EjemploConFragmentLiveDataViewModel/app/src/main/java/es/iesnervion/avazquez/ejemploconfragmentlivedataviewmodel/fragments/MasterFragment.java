package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.R;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.adapter.ContactAdapter;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.entities.ContactImpl;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewModel.SharedVM;

public class MasterFragment extends Fragment
implements AdapterView.OnItemClickListener
{

    SharedVM viewModel;
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.masterlayout, container, false);

        viewModel = ViewModelProviders.of(this).get(SharedVM.class);
        //ListView
        listView = view.findViewById(R.id.listViewContactos);

        //Adapter
        ContactAdapter contactAdapter = new ContactAdapter(getContext(), viewModel.getContactList().getValue());
        listView.setAdapter(contactAdapter);

        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Cuando un elemento se clicka, pongo ese elemento como
        //contacto seleccionado en el view model

        //Cojo el contacto seleccionado
        ContactImpl contactoSeleccionado = viewModel.getContactList().getValue().get(position);

        //Le digo al view model que este es el contacto seleccionado
        viewModel.setContactoSeleccionado(contactoSeleccionado);

    }
}

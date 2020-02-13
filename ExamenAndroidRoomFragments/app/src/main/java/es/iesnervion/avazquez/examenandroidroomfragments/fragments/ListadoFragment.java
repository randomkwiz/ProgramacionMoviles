package es.iesnervion.avazquez.examenandroidroomfragments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.avazquez.examenandroidroomfragments.R;
import es.iesnervion.avazquez.examenandroidroomfragments.adapters.AtletaAdapter;
import es.iesnervion.avazquez.examenandroidroomfragments.room.AppDatabase;
import es.iesnervion.avazquez.examenandroidroomfragments.room.entities.Atleta;
import es.iesnervion.avazquez.examenandroidroomfragments.viewModels.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment
        implements AdapterView.OnItemClickListener

{


    public ListadoFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.listViewAtletas)
    ListView listView;
    MainViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listado, container, false);
        ButterKnife.bind(this,view);
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        final AtletaAdapter adapter = new AtletaAdapter(viewModel.getListadoAtletas().getValue(), getActivity().getBaseContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);



        /*El observer para que se actualice la lista*/
//        final Observer<List<Atleta>> listObserver = new Observer<List<Atleta>>() {
//            @Override
//            public void onChanged(List<Atleta> contacts) {
//                listView.invalidate();
//                AtletaAdapter adapter1 = new AtletaAdapter(viewModel.getListadoAtletas().getValue()
//                        ,getActivity().getBaseContext());
//                listView.setAdapter(adapter1);
//            }
//        };
//        viewModel.getListadoAtletas().observe(this, listObserver);

        AppDatabase.getDatabase(getContext()).atletaDAO().getAllAtletasLD()
        .observe(this, new Observer<List<Atleta>>() {
            @Override
            public void onChanged(List<Atleta> listadoAtletas) {
                listView.invalidate();
                AtletaAdapter adapter1 = new AtletaAdapter(listadoAtletas
                        ,getActivity().getBaseContext());
                viewModel.setListadoAtletas(listadoAtletas);
                listView.setAdapter(adapter1);
            }
        });



        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Cuando un elemento se clicka, pongo ese elemento como
        //atleta seleccionado en el view model
        Atleta atletaSeleccionado = null;
        //Cojo el contacto seleccionado
        if(i >= 0){
//            atletaSeleccionado = AppDatabase
//                    .getDatabase(getActivity()).atletaDAO().getAtleta(i+1); //esto es la hostia de gitano
//
            atletaSeleccionado = viewModel.getListadoAtletas().getValue().get(i);

        }

        //Le digo al view model que este es el atleta seleccionado
        viewModel.setAtletaSeleccionado(atletaSeleccionado);
    }
}

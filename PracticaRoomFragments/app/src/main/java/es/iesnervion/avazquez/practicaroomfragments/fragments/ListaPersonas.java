package es.iesnervion.avazquez.practicaroomfragments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.avazquez.practicaroomfragments.R;
import es.iesnervion.avazquez.practicaroomfragments.adapters.ListaPersonasAdapter;
import es.iesnervion.avazquez.practicaroomfragments.viewModels.MainViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaPersonas extends Fragment {


    public ListaPersonas() {
        // Required empty public constructor
    }


    @BindView(R.id.listViewPersonas)
    ListView listViewPersonas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_personas, container, false);
        MainViewModel viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        ButterKnife.bind(this,view);

        ListaPersonasAdapter adapter = new ListaPersonasAdapter(viewModel.getListadoPersonas().getValue(), getContext());
        listViewPersonas.setAdapter(adapter);




        return view;
    }

}

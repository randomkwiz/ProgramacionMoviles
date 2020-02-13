package es.iesnervion.avazquez.examenandroidroomfragments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.avazquez.examenandroidroomfragments.R;
import es.iesnervion.avazquez.examenandroidroomfragments.room.entities.Atleta;
import es.iesnervion.avazquez.examenandroidroomfragments.viewModels.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetallesFragment extends Fragment {


    public DetallesFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.nombreAtleta)
    TextView nombreAtleta;
    @BindView(R.id.apellidoAtleta)
    TextView apellidoAtleta;
    @BindView(R.id.observacionesAtleta)
    TextView observaciones;

    MainViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);
        ButterKnife.bind(this,view);
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        if(viewModel.getAtletaSeleccionado().getValue() != null){
            nombreAtleta.setText(viewModel.getAtletaSeleccionado().getValue().getNombre());
            apellidoAtleta.setText(viewModel.getAtletaSeleccionado().getValue().getApellido());
            observaciones.setText(viewModel.getAtletaSeleccionado().getValue().getObservaciones());

        }



        //Observer para ATLETA SELECCIONADO
        /*El observer*/
        final Observer<Atleta> atletaSeleccionadoObserver = new Observer<Atleta>() {
            @Override
            public void onChanged(Atleta atleta) {
                if(viewModel.getAtletaSeleccionado().getValue() != null){
                    nombreAtleta.setText(viewModel.getAtletaSeleccionado().getValue().getNombre());
                    apellidoAtleta.setText(viewModel.getAtletaSeleccionado().getValue().getApellido());
                    observaciones.setText(viewModel.getAtletaSeleccionado().getValue().getObservaciones());
                }

            }
        };

        //Observo el LiveData con ese observer que acabo de crear
        viewModel.getAtletaSeleccionado().observe(this, atletaSeleccionadoObserver);



        return view;
    }

}

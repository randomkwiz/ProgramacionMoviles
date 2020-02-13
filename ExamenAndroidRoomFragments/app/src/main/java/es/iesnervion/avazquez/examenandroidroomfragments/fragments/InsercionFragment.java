package es.iesnervion.avazquez.examenandroidroomfragments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.avazquez.examenandroidroomfragments.R;
import es.iesnervion.avazquez.examenandroidroomfragments.viewModels.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsercionFragment extends Fragment implements View.OnClickListener {


    public InsercionFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.nombreAtleta)
    TextView nombreAtleta;
    @BindView(R.id.apellidoAtleta)
    TextView apellidoAtleta;
    @BindView(R.id.observacionesAtleta)
    TextView observaciones;
    @BindView(R.id.btnAdd)
    Button btnAdd;
    MainViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insercion, container, false);
        ButterKnife.bind(this,view);
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        btnAdd.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        viewModel.getAtletaInsertado().getValue()
                .setNombre(nombreAtleta.getText().toString().trim());
        viewModel.getAtletaInsertado().getValue()
                .setApellido(apellidoAtleta.getText().toString().trim());
        viewModel.getAtletaInsertado().getValue()
                .setObservaciones(observaciones.getText().toString().trim());


        if(!viewModel.getAtletaInsertado().getValue().getNombre().isEmpty() ||
                !viewModel.getAtletaInsertado().getValue().getApellido().isEmpty()
        ){

          viewModel.insertarAtleta();

        }else{
            Toast.makeText(getContext(), R.string.fillFields, Toast.LENGTH_SHORT).show();
        }


        //Limpiamos los campos

        nombreAtleta.setText("");
        apellidoAtleta.setText("");
        observaciones.setText("");
        viewModel.getAtletaInsertado().getValue().setNombre("");
        viewModel.getAtletaInsertado().getValue().setApellido("");
        viewModel.getAtletaInsertado().getValue().setObservaciones("");
    }
}

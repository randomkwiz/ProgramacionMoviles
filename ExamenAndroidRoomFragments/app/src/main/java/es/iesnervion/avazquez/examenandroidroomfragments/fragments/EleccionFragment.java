package es.iesnervion.avazquez.examenandroidroomfragments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.avazquez.examenandroidroomfragments.R;
import es.iesnervion.avazquez.examenandroidroomfragments.viewModels.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EleccionFragment extends Fragment implements View.OnClickListener {


    public EleccionFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.btnListado)
    Button btnList;
    @BindView(R.id.btnInsertar)
    Button btnInsert;
    MainViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eleccion, container, false);
        ButterKnife.bind(this,view);
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        btnList.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInsertar:
                viewModel.setIsElectionInsertPressed(true);
                break;
            case R.id.btnListado:
                viewModel.setIsElectionListPressed(true);
                break;
        }
    }
}

package es.iesnervion.avazquez.examenandroidroomfragments.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;
import es.iesnervion.avazquez.examenandroidroomfragments.R;
import es.iesnervion.avazquez.examenandroidroomfragments.fragments.DetallesFragment;
import es.iesnervion.avazquez.examenandroidroomfragments.fragments.EleccionFragment;
import es.iesnervion.avazquez.examenandroidroomfragments.fragments.InsercionFragment;
import es.iesnervion.avazquez.examenandroidroomfragments.fragments.ListadoFragment;
import es.iesnervion.avazquez.examenandroidroomfragments.room.entities.Atleta;
import es.iesnervion.avazquez.examenandroidroomfragments.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {


    @Nullable
    @BindView(R.id.layout_movil)
    ConstraintLayout layout_movil;

    @Nullable
    @BindView(R.id.layout_tablet)
    LinearLayout layout_tablet;
    MainViewModel viewModel;
    EleccionFragment eleccionFragment;
    ListadoFragment listadoFragment;
    InsercionFragment insercionFragment;
    DetallesFragment detallesFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        ButterKnife.bind(this);
        listadoFragment = new ListadoFragment();
        insercionFragment = new InsercionFragment();
        detallesFragment = new DetallesFragment();


        if(layout_tablet == null){
            //estamos en MOVIL
        eleccionFragment = new EleccionFragment();  //porque este solo se usara en movil


            /*El observer para LIST*/
            final Observer<Boolean> isBtnListPressedObserver = new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean isPressed) {
                    if(viewModel.getIsElectionListPressed().getValue()) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fragment, listadoFragment).addToBackStack(null).commit();

                    }
                }
            };

            //Observo el LiveData con ese observer que acabo de crear
            viewModel.getIsElectionListPressed().observe(this, isBtnListPressedObserver);




            /*El observer para INSERT*/
            final Observer<Boolean> isBtnInsertPressedObserver = new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean isPressed) {
                    if(viewModel.getIsElectionInsertPressed().getValue()) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fragment, insercionFragment).addToBackStack(null).commit();

                    }
                }
            };

            //Observo el LiveData con ese observer que acabo de crear
            viewModel.getIsElectionInsertPressed().observe(this, isBtnInsertPressedObserver);



            //Observer para ATLETA SELECCIONADO (si cambia te manda a detalles)
            /*El observer*/
            final Observer<Atleta> atletaSeleccionadoObserver = new Observer<Atleta>() {
                @Override
                public void onChanged(Atleta atleta) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment, detallesFragment).addToBackStack(null).commit();

                }
            };

            //Observo el LiveData con ese observer que acabo de crear
            viewModel.getAtletaSeleccionado().observe(this, atletaSeleccionadoObserver);


            getSupportFragmentManager().beginTransaction()
                    //.addToBackStack(null) //El primero no deberia poder volver atras
                    .replace(R.id.fragment, eleccionFragment)
                    .commit();



        }else{
            //estamos en TABLET
            getSupportFragmentManager().beginTransaction()
                    //.addToBackStack(null) //en tablet no se vuelve para atras
                    .replace(R.id.tablet_details, detallesFragment)
                    .commit();

            getSupportFragmentManager().beginTransaction()
                    //.addToBackStack(null) //en tablet no se vuelve para atras
                    .replace(R.id.tablet_insert, insercionFragment)
                    .commit();

            getSupportFragmentManager().beginTransaction()
                    //.addToBackStack(null) //en tablet no se vuelve para atras
                    .replace(R.id.tablet_list, listadoFragment)
                    .commit();
        }



    }
}

package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.res.Configuration;
import android.os.Bundle;

import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.fragments.DetailFragment;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.fragments.MasterFragment;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.interfaces.Contact;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewModel.SharedVM;

public class MainActivity extends AppCompatActivity {


    Fragment master;
    Fragment details;
    SharedVM viewModel;
    int orientacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(SharedVM.class);


        master = new MasterFragment();
        details = new DetailFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        orientacion = getResources().getConfiguration().orientation;
        if(orientacion == Configuration.ORIENTATION_PORTRAIT){
            fragmentTransaction.replace(R.id.masterFragment, master);

            /*Aqui hay que hacer que al clickar en un contacto cambie el fragment*/


        }else if(orientacion == Configuration.ORIENTATION_LANDSCAPE){
            fragmentTransaction.replace(R.id.masterFragment, master);
            fragmentTransaction.replace(R.id.detailsFragment, details);


        }


    }
}

package es.iesnervion.avazquez.examenandroid.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import es.iesnervion.avazquez.examenandroid.R;
import es.iesnervion.avazquez.examenandroid.adapters.AdaptadorSpinner;
import es.iesnervion.avazquez.examenandroid.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener, AdapterView.OnItemSelectedListener
{

    Spinner spinner;
    Button btn;
    MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        spinner = findViewById(R.id.spinnerMain);
        btn = findViewById(R.id.btnMain);
        ArrayList<String> listaString = viewModel.getListaItems().getValue();

        final ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                viewModel.getListaItems().getValue());

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(aa);


        //El observer de la lista
        final Observer<ArrayList<String>> listObserver = new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> list) {
                //Actualizar la UI
                spinner.setAdapter(aa);
            }
        };

        //Observo el LiveData con ese observer que acabo de crear
        viewModel.getListaItems().observe(this, listObserver);

        spinner.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent ;
        switch (view.getId()){
            case R.id.btnMain:
                //hago el intent a la segunda actividad
                intent = new Intent(this,SecondActivity.class );
                intent.putExtra("elementoElegido", viewModel.getItemSeleccionado().getValue());
                startActivity(intent);

        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //indico que cambia el elemento elegido
        if(i >= 0){
            viewModel.setItemSeleccionado(viewModel.getListaItems().getValue().get(i));

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

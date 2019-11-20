package es.iesnervion.avazquez.exampleviewmodel_livedata.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import es.iesnervion.avazquez.exampleviewmodel_livedata.MyAdapter;
import es.iesnervion.avazquez.exampleviewmodel_livedata.R;
import es.iesnervion.avazquez.exampleviewmodel_livedata.ViewModel.MainVM;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener
{

    Button btnAdd;
    ListView listView;
    MainVM viewModel;
    ArrayList<String> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainVM.class);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listViewMain);

        lista = viewModel.getLista().getValue();
        final MyAdapter adapter = new MyAdapter(this,lista);



        final Observer<ArrayList <String> >listObserver = new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                //Update UI
                listView.setAdapter(adapter);
            }
        };

        //Observa el livedata
        viewModel.getLista().observe(this, listObserver);




        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //this.lista.add("prueba");
        //this.lista.set(0, "CAMBIO WAPO");
        viewModel.setLista(lista);
    }
}

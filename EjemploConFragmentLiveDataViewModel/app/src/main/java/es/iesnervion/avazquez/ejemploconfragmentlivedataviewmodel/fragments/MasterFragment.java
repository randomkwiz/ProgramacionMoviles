package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.AppDatabase;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.R;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.adapter.ContactAdapter;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.entities.ContactImpl;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewModel.SharedVM;

public class MasterFragment extends Fragment
implements AdapterView.OnItemClickListener,
        View.OnClickListener
{

    SharedVM viewModel;
    ListView listView;
    ImageButton btnAddContact;
    ImageButton searchButton ;
    AutoCompleteTextView autoCompleteTextView;
    public MasterFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.masterlayout, container, false);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedVM.class);
        
        //ListView
        listView = view.findViewById(R.id.listViewContactos);

        searchButton = view.findViewById(R.id.searchButton);
        autoCompleteTextView = view.findViewById(R.id.autoCompleteMainActivity);

        btnAddContact = view.findViewById(R.id.addBtn);
        //Adapter
        final ContactAdapter contactAdapter = new ContactAdapter(getActivity().getBaseContext(), viewModel.getContactList().getValue());
        listView.setAdapter(contactAdapter);
        listView.setOnItemClickListener(this);
        btnAddContact.setOnClickListener(this);
        searchButton.setOnClickListener(this);


        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getBaseContext(),
                android.R.layout.simple_dropdown_item_1line,
                viewModel.getContactList().getValue());

        autoCompleteTextView.setAdapter(arrayAdapter);


        /*El observer*/
        final Observer<ArrayList<ContactImpl>> listObserver = new Observer<ArrayList<ContactImpl>>() {
            @Override
            public void onChanged(ArrayList<ContactImpl> contacts) {
                listView.invalidate();
                ContactAdapter contactAdapter1 = new ContactAdapter(getActivity().getBaseContext(), viewModel.getContactList().getValue());
                listView.setAdapter(contactAdapter1);

                   // contactAdapter.notifyDataSetChanged(); //-> con esto se actualiza al cambiar de fragment


            }
        };

        //Observo el LiveData con ese observer que acabo de crear
        viewModel.getContactList().observe(this, listObserver);



        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Cuando un elemento se clicka, pongo ese elemento como
        //contacto seleccionado en el view model
        ContactImpl contactoSeleccionado = null;
        //Cojo el contacto seleccionado
        if(position >= 0){
            contactoSeleccionado = viewModel.getContactList().getValue().get(position);
        }


        //Le digo al view model que este es el contacto seleccionado
        viewModel.setContactoSeleccionado(contactoSeleccionado);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.addBtn:
                viewModel.setIsAddBtnPressed(true);
                break;
            case R.id.searchButton:

                ContactImpl contactoSeleccionado = AppDatabase.getDatabase(getActivity().getBaseContext()).contactDAO()
                        .obtenerContactoPorNombre(autoCompleteTextView.getText().toString());

//                if(viewModel.getContactList().getValue().contains(contactoSeleccionado)){
//                    viewModel.setContactoSeleccionado(contactoSeleccionado);
//                }
                //Eso no funciona porque no es la misma referencia

                boolean encontrado = false;
                int index = 0;
                if(contactoSeleccionado != null){
                    for(int i = 0; i < viewModel.getContactList().getValue().size() && !encontrado; i ++){

                        if(viewModel.getContactList().getValue().get(i).getId() == contactoSeleccionado.getId()){
                            encontrado = true;
                            index = i;
                        }
                    }

                    viewModel.setContactoSeleccionado(viewModel.getContactList().getValue().get(index));
                }


                break;

        }
    }
}

package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.GregorianCalendar;

import de.hdodenhof.circleimageview.CircleImageView;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.AppDatabase;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.R;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.adapter.AdaptadorSpinner;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.entities.ContactImpl;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewModel.SharedVM;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment implements View.OnClickListener {

    EditText nombre;
    EditText apellidos;
    EditText bio;
    CircleImageView foto;
    DatePicker fechaNacimiento;
    GregorianCalendar fechaNacimientoEnGC;
    ContactImpl contactoCreado = new ContactImpl();
    Button addButton;
    Spinner spinnerContactoEmergencia;
    SharedVM viewModel;
    CheckBox checkboxIsFavorito;
    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedVM.class);

        nombre = view.findViewById(R.id.editName);
        apellidos = view.findViewById(R.id.editSurname);
        bio = view.findViewById(R.id.editBio);
        fechaNacimiento = view.findViewById(R.id.calendario);    //link con su xml
        fechaNacimiento.setMaxDate(viewModel.getFechaActual().getTimeInMillis());  //set max date tiene que estar DESPUES de hacer el link con su XML obviamente
        checkboxIsFavorito = view.findViewById(R.id.checkboxIsFavorito);

        foto = view.findViewById(R.id.imgContacto);
        addButton = view.findViewById(R.id.btnAdd);
        spinnerContactoEmergencia = view.findViewById(R.id.spinner_contactos);
        addButton.setOnClickListener(this);



        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(getActivity().getBaseContext(), viewModel.getContactList().getValue());
        spinnerContactoEmergencia.setAdapter(adaptadorSpinner);


        return view;
    }

    @Override
    public void onClick(View view) {

        fechaNacimientoEnGC = new GregorianCalendar(fechaNacimiento.getYear(), fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth());

        contactoCreado.setNombre(nombre.getText().toString());
        contactoCreado.setApellidos(apellidos.getText().toString());
        contactoCreado.setBiografia(bio.getText().toString());
        contactoCreado.setImgResource(R.drawable.imgdefault);
        contactoCreado.setFechaNacimiento(fechaNacimientoEnGC);

        if(checkboxIsFavorito.isChecked()){
            contactoCreado.setFavorito(true);
        }else{
            contactoCreado.setFavorito(false);
        }

        //Insertar en la BBDD
        AppDatabase.getDatabase(getActivity().getBaseContext()).contactDAO().insertContact(contactoCreado);

        //actualizar view model
        viewModel.cargarListaContactos();

        Toast toast = Toast.makeText(getContext(), "Contacto añadido", Toast.LENGTH_SHORT);
        toast.show();


    }
}

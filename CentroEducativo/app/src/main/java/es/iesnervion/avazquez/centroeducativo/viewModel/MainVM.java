package es.iesnervion.avazquez.centroeducativo.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.iesnervion.avazquez.centroeducativo.R;
import es.iesnervion.avazquez.centroeducativo.entities.Alumno;
import es.iesnervion.avazquez.centroeducativo.entities.Persona;
import es.iesnervion.avazquez.centroeducativo.entities.Profesor;

public class MainVM extends ViewModel {
    MutableLiveData<ArrayList<Persona>> listaPersonas;

    public MainVM() {
        this.listaPersonas = new MutableLiveData<ArrayList<Persona>>();
        cargarPersonas();
    }


    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas.getValue();
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas.setValue(listaPersonas);
    }


    private void cargarPersonas() {
        ArrayList<Persona> personaArrayList = new ArrayList<>();

        personaArrayList.add(new Profesor("Fernando", "Galiana", R.drawable.professor, ".NET"));
        personaArrayList.add(new Profesor("Miguel Angel", "Casado", R.drawable.professor, "Android"));
        personaArrayList.add(new Alumno("Ángela"));
        personaArrayList.add(new Alumno("Iván"));
        personaArrayList.add(new Profesor("Asuncion", "Criado", R.drawable.professor, "Programacion"));
        personaArrayList.add(new Alumno("Nzhdeh"));
        personaArrayList.add(new Alumno("Dani"));
        personaArrayList.add(new Profesor("Leo", "Acal", R.drawable.professor, "BBDD"));
        personaArrayList.add(new Alumno("Gonzalo"));
        personaArrayList.add(new Alumno("Pablo"));
        personaArrayList.add(new Profesor("Antonio", "", R.drawable.professor, "Acceso a Datos"));
        personaArrayList.add(new Profesor("Vicky", "", R.drawable.professor, "Inglés"));

        Profesor profesor = new Profesor("Profesor", "Profesor", R.drawable.professor, "Asignatura");
        Alumno alumno = new Alumno(("Alumno"));

        //Aleatorio para añadir profesores y alumnos
        for(int i = 0; i < 1000; i ++){
            int max = 10;
            int min = 1;
            int range = (max - min) + 1;
            int random =  (int)(Math.random() * range) + min;

            if(random > 5){
                personaArrayList.add(profesor);
            }else{
                personaArrayList.add(alumno);
            }
        }

        setListaPersonas(personaArrayList);
    }


}

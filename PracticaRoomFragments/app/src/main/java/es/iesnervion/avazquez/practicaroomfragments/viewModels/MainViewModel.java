package es.iesnervion.avazquez.practicaroomfragments.viewModels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import es.iesnervion.avazquez.practicaroomfragments.room.AppDatabase;
import es.iesnervion.avazquez.practicaroomfragments.room.entities.Persona;

public class MainViewModel extends AndroidViewModel {   //hace falta el contexto pa la bbdd
   private MutableLiveData<List<Persona>> listadoPersonas = new MutableLiveData<>();
   //Es final porque se usa dentro del async task

    public MainViewModel(Application application) {
        super(application);
        cargarPersonas();
    }

    public LiveData<List<Persona>> getListadoPersonas() {
        return listadoPersonas;
    }


    public void setListadoPersonas(List<Persona> listadoPersonas) {
        this.listadoPersonas.setValue(listadoPersonas);
    }



    private void cargarPersonas(){
        setListadoPersonas(AppDatabase.getDatabase(getApplication()).personaDAO().getAllPersonas());
    }


    private void cargarPersonasAsync(){
        //No funciona
        new AsyncTask<Void,Void,List<Persona>>() {
            @Override
            protected List<Persona> doInBackground(Void... voids) {
                List<Persona> personas = AppDatabase.getDatabase(getApplication()).personaDAO().getAllPersonas();
                return personas;
            }
            @Override
            protected void onPostExecute(List<Persona> data) {
                setListadoPersonas(data);
            }
        }.execute();
    }
}

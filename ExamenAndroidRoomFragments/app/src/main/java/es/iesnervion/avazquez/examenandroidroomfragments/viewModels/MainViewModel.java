package es.iesnervion.avazquez.examenandroidroomfragments.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.avazquez.examenandroidroomfragments.room.AppDatabase;
import es.iesnervion.avazquez.examenandroidroomfragments.room.entities.Atleta;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<Atleta>> listadoAtletas;
    private MutableLiveData<Atleta> atletaSeleccionado;
    private MutableLiveData<Atleta> atletaInsertado;

    //Para controlar la navegacion de fragments
    private MutableLiveData<Boolean> isElectionListPressed;
    private MutableLiveData<Boolean> isElectionInsertPressed;

    //Constructor
    public MainViewModel(@NonNull Application application) {
        super(application); //por si tenia que acceder a la bbdd desde el VM
        this.listadoAtletas = new MutableLiveData<>();
        this.atletaSeleccionado = new MutableLiveData<>();
        this.atletaInsertado = new MutableLiveData<>();
        this.isElectionListPressed = new MutableLiveData<>();
        this.isElectionInsertPressed = new MutableLiveData<>();



        this.isElectionInsertPressed.setValue(false);
        this.isElectionListPressed.setValue(false);
        this.listadoAtletas.setValue(new ArrayList<Atleta>());
        //this.atletaSeleccionado.setValue(new Atleta());
        this.atletaInsertado.setValue(new Atleta());

        getAllAtletas();
    }


    public LiveData<Atleta> getAtletaInsertado() {
        return atletaInsertado;
    }

    public void setAtletaInsertado(Atleta atletaInsertado) {
        this.atletaInsertado.setValue(atletaInsertado);
    }

    public LiveData<Boolean> getIsElectionListPressed() {
        return isElectionListPressed;
    }

    public void setIsElectionListPressed(Boolean isElectionListPressed) {
        if(isElectionListPressed){
            this.isElectionListPressed.setValue(isElectionListPressed);
            this.isElectionListPressed.setValue(false);
        }

    }

    public LiveData<Boolean> getIsElectionInsertPressed() {
        return isElectionInsertPressed;
    }

    public void setIsElectionInsertPressed(Boolean isElectionInsertPressed) {
        if(isElectionInsertPressed){
            this.isElectionInsertPressed.setValue(isElectionInsertPressed);
            this.isElectionListPressed.setValue(false);
        }

    }

    public LiveData<List<Atleta>> getListadoAtletas() {
        //getAllAtletas();
        return listadoAtletas;
    }

    public void setListadoAtletas(List<Atleta> listadoAtletas) {
        getAllAtletas();
        this.listadoAtletas.setValue(listadoAtletas);
    }

    public LiveData<Atleta> getAtletaSeleccionado() {
        return atletaSeleccionado;
    }

    public void setAtletaSeleccionado(Atleta atletaSeleccionado) {
        if(this.atletaSeleccionado.getValue() == null){
            this.atletaSeleccionado.setValue(new Atleta());
        }
        this.atletaSeleccionado.setValue(atletaSeleccionado);
    }



    //Metodo para insertar un atleta en la BBDD
    public void insertarAtleta(){
        AppDatabase.getDatabase(getApplication())
                .atletaDAO().insertarAtleta(this.getAtletaInsertado().getValue());

    }

    public void getAllAtletas(){
        this.listadoAtletas.setValue(AppDatabase.getDatabase(getApplication())
                .atletaDAO().getAllAtletas());
//        this.listadoAtletas = (MutableLiveData<List<Atleta>>) (AppDatabase.getDatabase(getApplication())
//                .atletaDAO().getAllAtletasLD());
    }

}

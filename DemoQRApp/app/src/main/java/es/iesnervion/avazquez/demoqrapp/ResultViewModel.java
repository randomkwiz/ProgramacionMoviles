package es.iesnervion.avazquez.demoqrapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResultViewModel extends ViewModel {
    private MutableLiveData<Integer> preguntasBasicasAcertadas;


    public ResultViewModel() {
        this.preguntasBasicasAcertadas = new MutableLiveData<>();
        this.preguntasBasicasAcertadas.setValue(0);
    }

    public LiveData<Integer> getPreguntasBasicasAcertadas() {
        return preguntasBasicasAcertadas;
    }

    public void setPreguntasBasicasAcertadas(Integer preguntasBasicasAcertadas) {
        this.preguntasBasicasAcertadas.setValue(preguntasBasicasAcertadas);
    }
}

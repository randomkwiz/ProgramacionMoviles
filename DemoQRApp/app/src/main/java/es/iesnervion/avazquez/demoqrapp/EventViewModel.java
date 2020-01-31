package es.iesnervion.avazquez.demoqrapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import es.iesnervion.avazquez.demoqrapp.entities.BasicQA;

public class EventViewModel extends ViewModel {
    private MutableLiveData<String> txtQR;
    private MutableLiveData<BasicQA> preguntaBasica;
    private MutableLiveData<Boolean> goToResults;


    public EventViewModel() {
        this.txtQR = new MutableLiveData<>();
        this.preguntaBasica = new MutableLiveData<>();
        this.goToResults = new MutableLiveData<>();
        this.goToResults.setValue(false);

        this.preguntaBasica.setValue(new BasicQA());

        this.setTxtQR("");
    }


    public LiveData<Boolean> getGoToResults() {
        return goToResults;
    }

    public void setGoToResults(Boolean goToResults) {
        if(goToResults){
            this.goToResults.setValue(goToResults);
            this.goToResults.setValue(false);
        }

    }

    public LiveData<BasicQA> getPreguntaBasica() {
        return preguntaBasica;
    }

    public void setPreguntaBasica(BasicQA preguntaBasica) {
        this.preguntaBasica.setValue(preguntaBasica);
    }

    public LiveData<String> getTxtQR() {
        return txtQR;
    }

    public void setTxtQR(String txtQR) {
        this.txtQR.setValue(txtQR);
    }
}

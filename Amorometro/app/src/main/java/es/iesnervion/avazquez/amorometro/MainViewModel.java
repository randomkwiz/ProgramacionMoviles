package es.iesnervion.avazquez.amorometro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    MutableLiveData<Boolean> isReqReady;
    MutableLiveData<Boolean> btnClicked;
    MutableLiveData<String> fName;
    MutableLiveData<String> sName;
    MutableLiveData<String> result;

    public MainViewModel() {
        this.isReqReady = new MutableLiveData<>();
            this.isReqReady.setValue(false);
        this.fName = new MutableLiveData<>();
            this.fName.setValue("");
        this.sName = new MutableLiveData<>();
            this.sName.setValue("");

        this.btnClicked = new MutableLiveData<>();
            this.btnClicked.setValue(false);

        this.result = new MutableLiveData<>();
        this.result.setValue("");
    }

    public LiveData<Boolean> getIsReqReady() {
        return isReqReady;
    }

    public void setIsReqReady(boolean isReqReady) {
        this.isReqReady.setValue(isReqReady);
    }

    public LiveData<String> getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName.setValue(fName);
    }

    public LiveData<String> getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName.setValue(sName);
    }

    public LiveData<Boolean> getBtnClicked() {
        return btnClicked;
    }

    public void setBtnClicked(boolean btnClicked) {
        this.btnClicked.setValue(btnClicked);
        if(btnClicked){
            play();
            setBtnClicked(false);
        }
    }

    public LiveData<String> getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result.setValue(result);
    }

    private void play() {
        if(!this.fName.getValue().isEmpty() && !this.sName.getValue().isEmpty()){
            Retrofit retrofit;

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://love-calculator.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))

                    .build();

            APILoveMeter apiInterface = retrofit.create(APILoveMeter.class);

            Call<JSONObjectLoveM> call = apiInterface
                    .getResultadoLoveMeter(this.fName.getValue(), this.sName.getValue());

            call.enqueue(new Callback<JSONObjectLoveM>() {
                @Override
                public void onResponse(Call<JSONObjectLoveM> call, Response<JSONObjectLoveM> response) {

                    if(response.isSuccessful()){

                        setResult(response.body().getResult());

                        setIsReqReady(true);

                    }else{
                        response.code();
                        response.body();
                        response.errorBody();
                        response.headers();
                    }
                }

                @Override
                public void onFailure(Call<JSONObjectLoveM> call, Throwable t) {
                    t.getStackTrace();

                }
            });
        }
    }
}

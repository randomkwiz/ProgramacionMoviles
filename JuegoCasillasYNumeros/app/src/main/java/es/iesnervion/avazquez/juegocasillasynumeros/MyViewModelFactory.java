package es.iesnervion.avazquez.juegocasillasynumeros;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import es.iesnervion.avazquez.juegocasillasynumeros.ViewModel.TableroViewModel;

public class MyViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    private ConstraintLayout layout;
    private int lado;
    private View gridFrame;
    public MyViewModelFactory(Application mApplication, ConstraintLayout layout, int lado, View gridFrame) {
        this.mApplication = mApplication;
        this.layout = layout;
        this.lado = lado;
        this.gridFrame = gridFrame;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        return (T) new TableroViewModel(mApplication, layout, lado, gridFrame);
    }
}

package es.iesnervion.avazquez.administracionappqr.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.ArrayList;

import es.iesnervion.avazquez.administracionappqr.R;
import es.iesnervion.avazquez.administracionappqr.viewModels.MainPageViewModel;

public class MainActivity extends AppCompatActivity {

/*
* https://www.android-examples.com/generate-qr-code-in-android-using-zxing-library-in-android-studio/
* */
    Spinner spinner;
    Button btnCrearPregunta;
    Button btnAnalizarQR;
    MainPageViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainPageViewModel.class);
        spinner = findViewById(R.id.spinnerMain);
        btnCrearPregunta = findViewById(R.id.btnCrearPregunta);
        btnAnalizarQR = findViewById(R.id.btnAnalizarQR);
        ArrayList<String> listaString = viewModel.getListaItems().getValue();

        final ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                viewModel.getListaItems().getValue());

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(aa);


    }



}

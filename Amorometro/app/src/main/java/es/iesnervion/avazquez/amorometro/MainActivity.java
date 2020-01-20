package es.iesnervion.avazquez.amorometro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MainViewModel viewModel;
    EditText fname;
    EditText sname;
    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.firstName);
        sname = findViewById(R.id.secondName);
        btn = findViewById(R.id.btnLoveMeter);
        result = findViewById(R.id.txtResult);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        btn.setOnClickListener(this);

        /*El observer*/
        final Observer<Boolean> isCargadaObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isCargada) {

                if(viewModel.getIsReqReady().getValue()){
                    result.setText(viewModel.getResult().getValue());
                    viewModel.setIsReqReady(false);
                }


            }
        };
        //Observo el LiveData con ese observer que acabo de crear
        viewModel.getIsReqReady().observe(this, isCargadaObserver);

    }

    @Override
    public void onClick(View view) {
        if(fname.getText().length()>0 && sname.getText().length()>0){
            viewModel.setfName(fname.getText().toString());
            viewModel.setsName(sname.getText().toString());

            viewModel.setBtnClicked(true);
        }else{
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            R.string.error, Toast.LENGTH_SHORT);

            toast1.show();
        }
    }
}

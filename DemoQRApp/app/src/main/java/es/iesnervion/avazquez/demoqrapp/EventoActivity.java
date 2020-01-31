package es.iesnervion.avazquez.demoqrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import butterknife.BindView;
import es.iesnervion.avazquez.demoqrapp.entities.BasicQA;
import es.iesnervion.avazquez.demoqrapp.entities.Pregunta;
import es.iesnervion.avazquez.demoqrapp.fragments.BasicQAFragment;

public class EventoActivity extends AppCompatActivity {


    EventViewModel viewModel;
    BasicQAFragment basicQAFragment;
    FirebaseFirestore firebaseFirestore;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        viewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        Intent intent = getIntent();
        String txt = intent.getStringExtra(Intent.EXTRA_TEXT);
        viewModel.setTxtQR(txt);
        firebaseFirestore = FirebaseFirestore.getInstance();
        basicQAFragment = new BasicQAFragment();
        obtenerPregunta();

        sharedPreferences = getSharedPreferences("ResultadosPreguntas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("basicQA_correct", 0);
        editor.putInt("basicQA_failed", 0);
        editor.putInt("complexQA_correct", 0);
        editor.putInt("complexQA_failed", 0);




//        Intent resultIntent = new Intent(this, ResultActivity.class);
//        intent.putExtra("type", "basicQA");
//        intent.putExtra("value", 1);
//
//        Observer<Boolean> resultsObserver = new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                if(aBoolean){
//                    startActivity(resultIntent);
//                }
//            }
//        };
//        viewModel.getGoToResults().observe(this, resultsObserver);




    }


    private void obtenerPregunta(){
        firebaseFirestore.collection("preguntas")
                .document(viewModel.getTxtQR().getValue())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    switch (documentSnapshot.getString("type")){
                        case "basicQA":
                            BasicQA basicQA = new BasicQA();
                            basicQA.setTipo(documentSnapshot.getString("type"));
                            basicQA.setTitulo(documentSnapshot.getString("question"));
                            basicQA.setRespuestaCorrecta(documentSnapshot.getString("correctAnswer"));
                            String[] arrayRespuestas = {
                                    documentSnapshot.getString("answer1"),
                                    documentSnapshot.getString("answer2"),
                                    documentSnapshot.getString("answer3"),
                                    documentSnapshot.getString("answer4")};
                            basicQA.setRespuestas(arrayRespuestas);

                            viewModel.setPreguntaBasica(basicQA);
                            getSupportFragmentManager().beginTransaction()
                                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                    .replace(R.id.fragment, basicQAFragment)
                                    .commit();
                            break;

                    }

                }
            }
        });
    }
}

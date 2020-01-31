package es.iesnervion.avazquez.demoqrapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.avazquez.demoqrapp.EventViewModel;
import es.iesnervion.avazquez.demoqrapp.R;
import es.iesnervion.avazquez.demoqrapp.ResultActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicQAFragment extends Fragment implements View.OnClickListener {


    public BasicQAFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.basicAQ_question)
    TextView question;

    @BindView(R.id.answer1)
    TextView a1;
    @BindView(R.id.answer2)
    TextView a2;
    @BindView(R.id.answer3)
    TextView a3;
    @BindView(R.id.answer4)
    TextView a4;
    @BindView(R.id.checkBtn)
    Button checkbtn;

    @BindView(R.id.rGroup_answers)
    RadioGroup radioGroup;

    SharedPreferences sharedPreferences;
    EventViewModel
    viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_qa, container, false);
        viewModel = ViewModelProviders.of(getActivity()).get(EventViewModel.class);

        ButterKnife.bind(this,view);

        question.setText(viewModel.getPreguntaBasica().getValue().getTitulo());
        a1.setText(viewModel.getPreguntaBasica().getValue().getRespuestas()[0]);
        a2.setText(viewModel.getPreguntaBasica().getValue().getRespuestas()[1]);
        a3.setText(viewModel.getPreguntaBasica().getValue().getRespuestas()[2]);
        a4.setText(viewModel.getPreguntaBasica().getValue().getRespuestas()[3]);


        sharedPreferences = getActivity()   //porque necesito algo que extienda de un contexto
                .getSharedPreferences("ResultadosPreguntas", Context.MODE_PRIVATE);


        checkbtn.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), ResultActivity.class);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int aciertos = sharedPreferences.getInt("basicQA_correct", 0);
        int fallos = sharedPreferences.getInt("basicQA_failed", 0);

        switch (v.getId()){
            case R.id.checkBtn:
                String mensaje = "";
                if(comprobarRespuesta(obtenerRespuestaSeleccionada())){
                    editor.putInt("basicQA_correct", ++aciertos);
                    mensaje = getString(R.string.correctAnswer);
                }else{
                    editor.putInt("basicQA_failed", ++fallos);
                    mensaje = getString(R.string.wrongAnswer);
                }
                editor.commit();
                Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();


                startActivity(intent);
                //viewModel.setGoToResults(true);
                break;
        }
    }

    private boolean comprobarRespuesta(String respuestaSeleccionada) {
        boolean isCorrect = false;
        if(viewModel.getPreguntaBasica().getValue().getRespuestaCorrecta().equals(respuestaSeleccionada)){
            isCorrect = true;
        }

        return isCorrect;
    }

    private String obtenerRespuestaSeleccionada() {
        int idRespuestaSeleccionada = radioGroup.getCheckedRadioButtonId();
        String respuestaSeleccionada = "";
        switch (idRespuestaSeleccionada){
            case R.id.answer1:
                respuestaSeleccionada = viewModel.getPreguntaBasica().getValue().getRespuestas()[0];
                break;
            case R.id.answer2:
                respuestaSeleccionada = viewModel.getPreguntaBasica().getValue().getRespuestas()[1];
                break;
            case R.id.answer3:
                respuestaSeleccionada = viewModel.getPreguntaBasica().getValue().getRespuestas()[2];
                break;
            case R.id.answer4:
                respuestaSeleccionada = viewModel.getPreguntaBasica().getValue().getRespuestas()[3];
                break;

        }

        return respuestaSeleccionada;
    }
}

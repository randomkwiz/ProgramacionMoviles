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
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.avazquez.demoqrapp.EventViewModel;
import es.iesnervion.avazquez.demoqrapp.R;
import es.iesnervion.avazquez.demoqrapp.ResultActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImgQAFragment extends Fragment implements View.OnClickListener {


    public ImgQAFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.imgQA_question)
    TextView question;
    @BindView(R.id.img1)
    ImageButton a1;
    @BindView(R.id.img2)
    ImageButton a2;
    @BindView(R.id.img3)
    ImageButton a3;
    @BindView(R.id.img4)
    ImageButton a4;

    SharedPreferences sharedPreferences;
    EventViewModel
            viewModel;
    Map<String,Integer> map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_img_qa, container, false);
        ButterKnife.bind(this,view);
        viewModel = ViewModelProviders.of(getActivity()).get(EventViewModel.class);
        question.setText(viewModel.getPreguntaImagenes().getValue().getTitulo());

        sharedPreferences = getActivity()   //porque necesito algo que extienda de un contexto
                .getSharedPreferences("ResultadosPreguntas", Context.MODE_PRIVATE);


        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);


        map = new HashMap<>();
        map.put(
                viewModel.getPreguntaImagenes().getValue().getRespuestas()[0]
                ,
                a1.getId());
        map.put(
                viewModel.getPreguntaImagenes().getValue().getRespuestas()[1]
                ,
                a2.getId());
        map.put(viewModel.getPreguntaImagenes().getValue().getRespuestas()[2] ,
                a3.getId()
                );
        map.put(
                viewModel.getPreguntaImagenes().getValue().getRespuestas()[3]
                ,
                a4.getId());

        //a cada elemento picasso le pongo como tag su propia url porque me hace falta despues

        Picasso.get()
                .load(
                        viewModel
                                .getPreguntaImagenes()
                                .getValue()
                                .getRespuestas()[0]
                )
                .fit()
                .into(a1);

        Picasso.get()
                .load(
                        viewModel
                                .getPreguntaImagenes()
                                .getValue()
                                .getRespuestas()[1])
                .fit()
                .into(a2);

        Picasso.get()
                .load(
                        viewModel
                                .getPreguntaImagenes()
                                .getValue()
                                .getRespuestas()[2])
                .fit()
                .into(a3);

        Picasso.get()
                .load(
                        viewModel
                                .getPreguntaImagenes()
                                .getValue()
                                .getRespuestas()[3])
                .fit()
                .into(a4);


        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), ResultActivity.class);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int aciertos = sharedPreferences.getInt("imgQA_correct", 0);
        int fallos = sharedPreferences.getInt("imgQA_failed", 0);
        String mensaje = "";
        v = (ImageButton) v;

        if(v.getId() == obtenerIDRespuestaCorrecta()){

            editor.putInt("imgQA_correct", ++aciertos);
            mensaje = getString(R.string.correctAnswer);
        }else{
            editor.putInt("imgQA_failed", ++fallos);
            mensaje = getString(R.string.wrongAnswer);
        }

        editor.commit();
        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    private int obtenerIDRespuestaCorrecta(){
        return ( map.get(viewModel.getPreguntaImagenes().getValue().getRespuestaCorrecta()) );
    }


}

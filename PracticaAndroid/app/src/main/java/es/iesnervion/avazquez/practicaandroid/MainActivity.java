package es.iesnervion.avazquez.practicaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener
{

    Button next;
    Button prev;
    LinkedList<Integer> listaImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);

        prev.setEnabled(false);

        prev.setOnClickListener(this);
        next.setOnClickListener(this);
        listaImg.add(0,R.drawable.goose1);
        listaImg.add(1,R.drawable.goose2);
        listaImg.add(2,R.drawable.goose3);
        listaImg.add(3,R.drawable.goose4);

    }

    @Override
    public void onClick(View v) {
        ImageButton img1 = findViewById(R.id.img1);
        ImageButton img2 = findViewById(R.id.img2);
        switch (v.getId()){
            case R.id.prev:
                img1.setBackgroundResource(listaImg.get(0));
                img2.setBackgroundResource(listaImg.get(1));
                prev.setEnabled(false);
                next.setEnabled(true);
                break;
            case R.id.next:
                img1.setBackgroundResource(listaImg.get(2));
                img2.setBackgroundResource(listaImg.get(3));
                prev.setEnabled(true);
                next.setEnabled(false);

                break;

        }
    }

}

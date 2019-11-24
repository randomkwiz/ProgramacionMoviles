package es.iesnervion.avazquez.simplefragmentexample;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import es.iesnervion.avazquez.simplefragmentexample.fragments.FirstFragment;
import es.iesnervion.avazquez.simplefragmentexample.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener
{
    Fragment first;
    Fragment second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = new FirstFragment();
        second = new SecondFragment();

        findViewById(R.id.fragment1).setOnClickListener(this);
        findViewById(R.id.fragment2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (v.getId()){
            case R.id.fragment1:
                fragmentTransaction.replace(R.id.layout, first);
                break;
            case R.id.fragment2:
                fragmentTransaction.replace(R.id.layout, second);
                break;

        }
        fragmentTransaction.commit();
    }
}
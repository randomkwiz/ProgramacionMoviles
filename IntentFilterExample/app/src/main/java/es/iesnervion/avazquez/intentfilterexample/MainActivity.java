package es.iesnervion.avazquez.intentfilterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.txt);

        // Get the intent that started this activity
        Intent intent = getIntent();

        Uri data = intent.getData();

        if(getIntent().getStringExtra(Intent.EXTRA_TEXT) != null){
        txt.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));



        }
    }
}

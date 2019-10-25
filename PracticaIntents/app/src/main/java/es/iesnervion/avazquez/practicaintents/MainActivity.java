package es.iesnervion.avazquez.practicaintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView_main);
        String[] opciones = {"Mapas", "Musica", "Foto", "Web", "Llamar"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;

        switch (position){
            case 0:
                //Mapas
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.4004727,-5.9733553"));
                break;
            case 1:
                //Musica
                intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                File file = //TODO hacer esto
                intent.setDataAndType(FileProvider.getUriForFile(this,this.getApplicationContext().getPackageName()+ ".fileprovider", file), "audio/mp3");
                startActivity(intent);
            break;
            case 2:
                //Foto
                break;
            case 3:
                //Web
                 intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cdn.memegenerator.es/imagenes/memes/full/30/64/30642559.jpg"));
                break;
            case 4:
                //Llamar
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:685785611"));
                break;

        }
        startActivity(intent);

    }
}

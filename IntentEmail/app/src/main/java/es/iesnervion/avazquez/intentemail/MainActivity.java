package es.iesnervion.avazquez.intentemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener
{

    Button submit;
    EmailImpl correo;
    TextView emailDest ;
    TextView subject;
    TextView mensaje ;
    Intent correoIntent;
    ImageView adjuntar;
    ImageView imagenAdjunta;

    Uri uriImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailDest = findViewById(R.id.txtEmailDestinatario);
        subject = findViewById(R.id.txtSubject);
        mensaje = findViewById(R.id.txtMensaje);
        submit = findViewById(R.id.submitBtn);
        adjuntar = findViewById(R.id.btnAttachFile);
        imagenAdjunta = findViewById(R.id.imgAttached);

        submit.setOnClickListener(this);
        adjuntar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId()){
            case R.id.submitBtn:
                correo = new EmailImpl(emailDest.getText().toString(), subject.getText().toString(), mensaje.getText().toString());
                correoIntent = new Intent(Intent.ACTION_SEND);
                correoIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{correo.getEmailDestinatario()});
                correoIntent.putExtra(Intent.EXTRA_SUBJECT, correo.getSubject());
                correoIntent.putExtra(Intent.EXTRA_TEXT, correo.getMsj());

                //TODO esto no funciona
                if(uriImagen != null){
                    correoIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(uriImagen.getPath())));
                }

                //pa que me salgan solo clientes de correo
                correoIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(correoIntent, "Elige un cliente de correo: "));
                break;
            case R.id.btnAttachFile:
                //TODO esto no coge la imagen ni a la de tres he probado de todo
                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                intent.setType("image/*");

                startActivityForResult(intent, RESULT_OK);


                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            imagenAdjunta.setImageURI(selectedImage);
        }



    }
}

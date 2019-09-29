package es.iesnervion.avazquez.aplicacionprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener
{

    EditText nombre;
    EditText apellidos;
    RadioButton male;
    RadioButton female;
    CheckBox perro;
    CheckBox gato;
    CheckBox pajaro;
    Button enviar;
    String firstName;
    String lastName;
    TextView resultado ;
    Button limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.firstName);

        apellidos = findViewById(R.id.lastName);

        male = findViewById(R.id.radioButtonMale);
        female = findViewById(R.id.radioButtonFemale);
        perro = findViewById(R.id.checkboxDog);
        gato = findViewById(R.id.checkboxCat);
        pajaro = findViewById(R.id.checkboxBird);
        enviar = findViewById(R.id.submit);
        resultado = findViewById(R.id.resultado);
        limpiar = findViewById(R.id.clean);

        enviar.setOnClickListener(this);
        limpiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String res = "";
        switch (v.getId()){
            case R.id.submit:
                String selected = radioButtonSelected();
                firstName = nombre.getText().toString();
                lastName = apellidos.getText().toString();

                res = "Tu nombre es: " + firstName + "\n"
                        +"Tu apellido es: " + lastName + "\n"
                        +"Tu sexo es: " + selected + "\n"
                        +"Animales favoritos: " + "\n";

                if(perro.isChecked()){

                    res += "Perros \n";
                }
                if(gato.isChecked()){
                    res += "Gatos \n";
                }
                if(pajaro.isChecked()){
                    res += "Pajaros \n";
                }
                if (!pajaro.isChecked() && !gato.isChecked() && !perro.isChecked()){
                    res += "Ningún animal de los elegibles era tu favorito.\n";
                }


                break;

            case R.id.clean:
                res = "";
                nombre.setText("");
                apellidos.setText("");
                break;

        }

        resultado.setText(res);

    }

    /*Devuelve el radio button elegido*/
    public String radioButtonSelected (){
        String selected;
        if(male.isChecked()){
            selected = "Masculino";
        }else{
            selected = "Femenino";
        }

        return selected;
    }






}

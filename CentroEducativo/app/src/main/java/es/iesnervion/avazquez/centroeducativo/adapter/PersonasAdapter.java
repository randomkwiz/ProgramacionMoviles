package es.iesnervion.avazquez.centroeducativo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.avazquez.centroeducativo.R;
import es.iesnervion.avazquez.centroeducativo.entities.Alumno;
import es.iesnervion.avazquez.centroeducativo.entities.Persona;
import es.iesnervion.avazquez.centroeducativo.entities.Profesor;
import es.iesnervion.avazquez.centroeducativo.viewHolder.ViewHolderAlumno;
import es.iesnervion.avazquez.centroeducativo.viewHolder.ViewHolderProfesor;

public class PersonasAdapter extends BaseAdapter {

    Context context;
    ArrayList<Persona> listaPersonas;


    public PersonasAdapter(Context context, ArrayList<Persona> listaPersonas) {
        this.context = context;
        this.listaPersonas = listaPersonas;
    }

    @Override
    public int getCount() {
        return listaPersonas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*
    * Devuelve 0 si es tipo profesor
    * devuelve 1 si es tipo alumno
    * */
    @Override
    public int getItemViewType(int position) {
        int tipo = -1;
        //Lo hago asi por si en un futuro hay mas tipos
        if(listaPersonas.get(position) instanceof Profesor){
            tipo = 0;
        }else if (listaPersonas.get(position) instanceof Alumno){
            tipo = 1;
        }

        return tipo;
    }

    /*Devuelve la cantidad de tipos diferentes que hay, en este caso son dos
    * elementos diferentes.
    * Es como un array, 0 y 1.*/
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Persona personaElegida = listaPersonas.get(position);   //elemento elegido
        ViewHolderProfesor viewHolderProfesor = null;
        ViewHolderAlumno viewHolderAlumno = null;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            if(getItemViewType(position) == 0)  //es un profesor
            {
                convertView = inflater.inflate(R.layout.row_profesor, parent, false);

                //Creamos referencias

                ImageView fotoProfesor = (ImageView) convertView.findViewById(R.id.imagenProfesor);
                TextView nombreProfesor = (TextView) convertView.findViewById(R.id.nombreProfesor);
                TextView asignaturaProfesor = (TextView) convertView.findViewById(R.id.asignaturaProfesor);

                //Le ponemos esas referencias al prof actual
                fotoProfesor.setImageResource(personaElegida.getImgSrc());
                nombreProfesor.setText(personaElegida.getNombre());
                asignaturaProfesor.setText((((Profesor) personaElegida).getAsignaturaPrincipal()));


                viewHolderProfesor = new ViewHolderProfesor(fotoProfesor, nombreProfesor, asignaturaProfesor);


                //convertView.setTag(R.id.PROFESOR, viewHolderProfesor);
                convertView.setTag(viewHolderProfesor);


            }else if(getItemViewType(position) == 1) { //es un alumno
                convertView = inflater.inflate(R.layout.row_alumno, parent, false);

                TextView nombreAlumno = convertView.findViewById(R.id.nombreAlumno);

                nombreAlumno.setText(personaElegida.getNombre());

                viewHolderAlumno = new ViewHolderAlumno(nombreAlumno);

                //convertView.setTag(R.id.ALUMNO, viewHolderAlumno);
                convertView.setTag(viewHolderAlumno);

            }   //ojito angela con poner aqui el else del if convert view == null ,
            // que te hace mal el reciclaje (obviamente) porque no es aqui, es abajo xD

            }else{
            if(getItemViewType(position) == 0){ //profesor
                //viewHolderProfesor = (ViewHolderProfesor) convertView.getTag(R.id.PROFESOR);
                viewHolderProfesor = (ViewHolderProfesor) convertView.getTag();


            }else if (getItemViewType(position) == 1){  //alumno
                //viewHolderAlumno = (ViewHolderAlumno) convertView.getTag(R.id.ALUMNO);

                viewHolderAlumno = (ViewHolderAlumno) convertView.getTag();
            }

            //Actualizamos los elementos

            if(getItemViewType(position) == 0){ //profesor
                viewHolderProfesor.getFotoProfesor().setImageResource(personaElegida.getImgSrc());
                viewHolderProfesor.getNombreProfesor().setText(personaElegida.getNombre());
                viewHolderProfesor.getAsignaturaProfesor().setText(((Profesor)personaElegida).getAsignaturaPrincipal());

            }else if (getItemViewType(position) == 1){  //alumno
                viewHolderAlumno.getNombreAlumno().setText(personaElegida.getNombre());
            }


        }

        return convertView;
    }
}

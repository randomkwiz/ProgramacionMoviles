package es.iesnervion.avazquez.ejerciciolistanba_1.Utilidades

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import es.iesnervion.avazquez.ejerciciolistanba_1.Clases.EmpresaImpl
import es.iesnervion.avazquez.ejerciciolistanba_1.R
import kotlin.math.log

class EmpresaAdapter (listaEmpresas: ArrayList<EmpresaImpl>, contexto: Context) : BaseAdapter() {

    private var listaEmpresas: ArrayList<EmpresaImpl> = listaEmpresas;
    private val contexto: Context = contexto;
    private val inflador : LayoutInflater = LayoutInflater.from(contexto);


    override fun getCount(): Int {
       return listaEmpresas.size;
    }


    override fun getItem(position: Int): Any {
        return 0;
    }

    override fun getItemId(position: Int): Long {
        return 0;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Get view for row item
        val view: View
        val holder: ViewHolder
        val logo: CircleImageView
        val nombre: TextView
        val empresaActual = listaEmpresas.get(position)

        if(convertView == null){
            view = inflador.inflate(R.layout.equipo, parent, false)

             logo = view.findViewById<CircleImageView>(R.id.imagen)
             nombre = view.findViewById<TextView>(R.id.nombre)

            nombre.text = empresaActual.getNombreEmpresa()
            logo.setImageResource(empresaActual.getLogo())

            holder = ViewHolder(nombre, logo)

            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        holder.nombreEmpresa.text = empresaActual.getNombreEmpresa()
        holder.logo.setImageResource(empresaActual.getLogo())

        return view
    }
}
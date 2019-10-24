package es.iesnervion.avazquez.recyclerviewkotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.avazquez.recyclerviewkotlin.R
import kotlinx.android.synthetic.main.layout_row_lista.view.*

class CustomStringAdapter (items:ArrayList<String>, context: Context): RecyclerView.Adapter<CustomStringAdapter.ViewHolder>() {

    var items:ArrayList<String> = items
    var context: Context = context
    var viewHolder:ViewHolder? = null

    //devuelve el view holder con el layout indicado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomStringAdapter.ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.layout_row_lista, parent, false)

        viewHolder = ViewHolder(vista)


        return viewHolder!! //se pone !! pa indicar que no pueda ser nulo
    }

    override fun getItemCount(): Int {
        return this.items.count()
    }

    //bindea elementos del holder con los del elemento que toque
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var elementoActual: String = items[position]


        holder.nombre.text = elementoActual
         }


    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        //var vista = vista

        var nombre: TextView = vista.nombre


    }
}
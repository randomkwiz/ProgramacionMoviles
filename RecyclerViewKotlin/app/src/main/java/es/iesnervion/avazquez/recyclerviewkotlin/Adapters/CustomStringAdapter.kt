package es.iesnervion.avazquez.recyclerviewkotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_row_lista.view.*

class CustomStringAdapter (items:ArrayList<String>, context: Context): RecyclerView.Adapter<CustomStringAdapter.ViewHolder>() {

    var items:ArrayList<String> = items
    var context: Context = context
    var viewHolder:ViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomStringAdapter.ViewHolder {
        val vista = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        viewHolder = ViewHolder(vista)


        return viewHolder!! //se pone !! pa indicar que no pueda ser nulo
    }

    override fun getItemCount(): Int {
        return this.items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var elementoActual: String = items.get(position)


        holder.nombre.text = elementoActual
         }


    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        //var vista = vista

        var nombre: TextView = vista


    }
}
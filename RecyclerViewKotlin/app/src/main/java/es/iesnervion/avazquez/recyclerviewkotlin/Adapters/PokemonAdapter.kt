package es.iesnervion.avazquez.recyclerviewkotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Pokemon
import es.iesnervion.avazquez.recyclerviewkotlin.R
import kotlinx.android.synthetic.main.layout_row_lista.view.*

class PokemonAdapter(items:ArrayList<Pokemon>,
                     private val clickListener: (Pokemon) -> Unit,
                     context: Context):
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    var items:ArrayList<Pokemon> = items
    var context:Context = context
    var viewHolder:ViewHolder? = null


    //será quien devuelva el ViewHolder con el layout seteado que previamente
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.layout_row_lista, parent, false)
        viewHolder = ViewHolder(vista)


        return viewHolder!! //se pone !! pa obligar que no pueda ser nulo (esto pasa porque previamente lo hemos marcao como sí nulable)
    }

    override fun getItemCount(): Int {
        return this.items.count()
    }

    //será quien se encargue de establecer los objetos en el ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*Bindea informacion con el layout*/

        var elementoActual: Pokemon = items.get(position)

        holder.foto.setImageResource(elementoActual.img)
        holder.nombre.text = elementoActual.name



        holder.bind(items[position], clickListener)

    }





    /*Voy a hacer el View Holder aqui, de forma interna*/

    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        //var vista = vista
        var foto: ImageView = vista.img
        var nombre: TextView = vista.nombre

        /*Le ponemos un listener a cada elemento*/
        fun bind(pokemon: Pokemon, clickListener: (Pokemon) -> Unit) {
            itemView.nombre.text = pokemon.name
            itemView.setOnClickListener { clickListener(pokemon)}
        }

    }
}
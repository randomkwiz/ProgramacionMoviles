package es.iesnervion.avazquez.recyclerviewkotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.avazquez.recyclerviewkotlin.Clases.Movimiento
import es.iesnervion.avazquez.recyclerviewkotlin.R
import kotlinx.android.synthetic.main.layout_row_lista.view.*

class MovimientosAdapter (context: Context, listaMovimientos: ArrayList<Movimiento>)    //Constructor

    : RecyclerView.Adapter<MovimientosAdapter.ViewHolder>() // (hereda) -> se indica que tendra un RecyclerView + ViewHolder que
                                                            // estara dentro de la clase MovimientosAdapter (esta abajo)
{
    val context: Context = context
    val listaMovimientos = listaMovimientos

    /*onCreateViewHolder() nos devuelve un objeto ViewHolder
    al cual le hemos pasado previamente la celda que hemos inflado.*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(context)
        var vista:View = layoutInflater.inflate(R.layout.layout_row_lista, parent, false)
        var viewHolder: ViewHolder  = ViewHolder(vista)

        return viewHolder
    }

    override fun getItemCount(): Int {
       return listaMovimientos.count()
    }

    /*onBindViewHolder() se encarga de coger cada una de las posiciones
    de la lista de movimientos y pasarlas a la clase ViewHolder
    para que esta haga todos los elementos.*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var movimientoActual = listaMovimientos[position]


        holder.nombre.text = movimientoActual.ename

        //Pondrá una foto u otra dependiendo del tipo del movimiento
        when(movimientoActual.tipo){
            "Bug" -> holder.foto.setImageResource(R.drawable.bug)
            "Dark" -> holder.foto.setImageResource(R.drawable.dark)
            "Dragon" -> holder.foto.setImageResource(R.drawable.dragon)
            "Electric" -> holder.foto.setImageResource(R.drawable.electric)
            "Fairy" -> holder.foto.setImageResource(R.drawable.fairy)
            "Fighting" -> holder.foto.setImageResource(R.drawable.fighting)
            "Fire" -> holder.foto.setImageResource(R.drawable.fire)
            "Flying" -> holder.foto.setImageResource(R.drawable.flying)
            "Ghost" -> holder.foto.setImageResource(R.drawable.ghost)
            "Grass" -> holder.foto.setImageResource(R.drawable.grass)
            "Ground" -> holder.foto.setImageResource(R.drawable.ground)
            "Ice" -> holder.foto.setImageResource(R.drawable.ice)
            "Normal" -> holder.foto.setImageResource(R.drawable.normal)
            "Poison" -> holder.foto.setImageResource(R.drawable.poison)
            "Psychic" -> holder.foto.setImageResource(R.drawable.psychic)
            "Rock" -> holder.foto.setImageResource(R.drawable.rock)
            "Steel" -> holder.foto.setImageResource(R.drawable.steel)
            "Water" -> holder.foto.setImageResource(R.drawable.water)
        }
    }


    /*Clase View Holder a la que le pasamos la vista*/
    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){

        var foto: ImageView = vista.img
        var nombre: TextView = vista.nombre



    }
}
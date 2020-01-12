package es.iesnervion.avazquez.ejemplokotlinretrofit2

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val myImageView: ImageView = itemView.findViewById(R.id.foto)

    fun updateWithUrl(url: String) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.perroprueba)
            .error(R.drawable.ic_launcher_background)
            .fit()
            .into(myImageView)
        //metodo with() fue renombrado a get()
    }
}
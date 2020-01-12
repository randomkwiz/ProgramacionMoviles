package es.iesnervion.avazquez.ejemplokotlinretrofit2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.avazquez.ejemplokotlinretrofit2.ImageHolder
import es.iesnervion.avazquez.ejemplokotlinretrofit2.R

class ImageAdapter() : RecyclerView.Adapter<ImageHolder>() {
    val imageUrls: Array<String> = //arrayOf("https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg")
        arrayOf( "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_1023.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10263.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10715.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10822.jpg")


    override fun getItemCount(): Int {
        return imageUrls.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val imageItem = LayoutInflater.from(parent.context).inflate(R.layout.imagelist_row, parent, false)
        return ImageHolder(imageItem)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val imageUrl = imageUrls[position]
        holder.updateWithUrl(imageUrl)
    }


}
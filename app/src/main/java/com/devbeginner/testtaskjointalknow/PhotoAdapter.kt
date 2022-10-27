package com.devbeginner.testtaskjointalknow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter() : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private var values: List<String> = ArrayList()

    fun setItemList(newPhotos: List<String>) {
        values = newPhotos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_conteiner_photo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.photoImageView?.setImageResource(R.drawable.image_4)
        //holder.photoImageView?.setImageURI(values[position].toUri())
    }

    override fun getItemCount(): Int {
        return values.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photoImageView: ImageView? = null

        init {
            photoImageView = itemView.findViewById(R.id.iv_photo)
        }
    }

}
package com.dev.assignment.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.assignment.data.api.main.responseModel.Photo
import com.dev.assignment.databinding.ItemPhotoBinding
import com.dev.assignment.ui.main.view.MainActivity

class PhotosAdpater
    constructor(
        val activity: MainActivity,
        var photos : ArrayList<Photo>
        ) : RecyclerView.Adapter<PhotosAdpater.PhotosViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        var itemPhotoBinding=ItemPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhotosViewHolder(itemPhotoBinding)

    }


    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = photos.get(position)
        holder.itemPhotoBinding.photo = photo
        holder.itemPhotoBinding.activity = activity
    }


    fun updatePhotos(photos:List<Photo>) {
        this.photos.apply {
            addAll(photos)
        }
        notifyDataSetChanged()

    }


    class PhotosViewHolder(var itemPhotoBinding: ItemPhotoBinding) : RecyclerView.ViewHolder(itemPhotoBinding.root)



}

package com.elhacene.pixwall.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.elhacene.pixwall.R

class PhotoAdapter(private val photos : ArrayList<String>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // inflates the card_view_design view
            // that is used to hold list item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image, parent, false)

            return ViewHolder(view)
        }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val photo = photos[position]

            // sets the image to the imageview from our itemHolder class
            try {
                Glide.with(holder.itemView)
                    .load(photo)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    //.placeholder(R.drawable.spr)
                    .into(holder.imageView);
                //Picasso.get().load("https://images.unsplash.com/photo-1687599556215-536da19dc9ca?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80").into(holder.imageView);
            }
            catch (e: Exception){
                Log.e("Error",e.message.toString())
            }

        }

        // return the number of the items in the list
        override fun getItemCount(): Int {
            return photos.size
        }

        // Holds the views for adding it to image and text
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val imageView: ImageView = itemView.findViewById(R.id.item_image_grid_img)
        }
    }
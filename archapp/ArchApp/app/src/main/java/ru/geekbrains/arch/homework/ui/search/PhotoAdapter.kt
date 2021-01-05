package ru.geekbrains.arch.homework.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ru.geekbrains.arch.homework.GlideApp
import ru.geekbrains.arch.homework.R
import ru.geekbrains.arch.homework.domain.Photo
import java.util.*

class PhotoAdapter(private val fragment: Fragment) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var photos: List<Photo> = Collections.emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(view, fragment)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun update(photos: List<Photo>) {
        this.photos = photos
        notifyDataSetChanged()
    }

    class PhotoViewHolder(private val itemView: View, private val fragment: Fragment) :
        RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.photo_item_image)

        fun bind(photo: Photo) {
            GlideApp.with(fragment)
                .load(photo.url)
                .placeholder(R.drawable.ic_no_photo_vector)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(image);
        }
    }
}

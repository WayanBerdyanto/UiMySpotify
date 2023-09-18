package com.dicoding.myspotify

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListSongAdapter(private val listSong: ArrayList<Song>) : RecyclerView.Adapter<ListSongAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitleSong: TextView = itemView.findViewById(R.id.tv_title_song)
        val tvAuthSong: TextView = itemView.findViewById(R.id.tv_text_auth)
        val tvView: TextView = itemView.findViewById(R.id.tv_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_song, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listSong.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, auth,views, photo) = listSong[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvTitleSong.text = title
        holder.tvAuthSong.text = auth
        holder.tvView.text = views
        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_song", listSong[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}
package com.dicoding.myspotify

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {

    companion object {
        const val EXTRA_SONG = "key_song"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tvTitleDetail: TextView = findViewById(R.id.tv_title_detail_song)
        val tvAuthDetailSong: TextView = findViewById(R.id.tv_auth_detail_song)
        val imgDetailPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvDetailDesc: TextView = findViewById(R.id.tv_detail_description)
        val tvView: TextView = findViewById(R.id.tv_detail_view)

        val dataSong = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Song>(EXTRA_SONG, Song::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Song>(EXTRA_SONG)
        }
        if (dataSong != null) {
            tvTitleDetail.text = dataSong.titleSong
            tvAuthDetailSong.text = dataSong.authSong
            imgDetailPhoto.setImageResource(dataSong.photoSong)
            tvDetailDesc.text = dataSong.descriptionSong
            tvView.text = dataSong.view
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT, "Cek Keluar ini Aplikasi MySpotify")
                intent.putExtra(Intent.EXTRA_TEXT, "Ap")
                startActivity(Intent.createChooser(intent, "Share Via"))
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
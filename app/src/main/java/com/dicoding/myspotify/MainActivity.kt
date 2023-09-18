package com.dicoding.myspotify

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var rvSongs: RecyclerView

    private val list = ArrayList<Song>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSongs = findViewById(R.id.rv_song)
        rvSongs.setHasFixedSize(true)

        list.addAll(getListSongs())
        showRecyclerList()
    }
    private fun getListSongs(): ArrayList<Song>{
        val dataSongName = resources.getStringArray(R.array.data_song_name)
        val dataAuthSong = resources.getStringArray(R.array.data_auth_song)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataView = resources.getStringArray(R.array.data_views)
        val listMusic = ArrayList<Song>()
        for(i in dataSongName.indices){
            val song = Song(dataSongName[i], dataAuthSong[i],dataView[i], dataPhoto.getResourceId(i, -1), dataDesc[i])
            listMusic.add(song)
        }
        return  listMusic
    }

    private fun showRecyclerList(){
        rvSongs.layoutManager = LinearLayoutManager(this)
        val listSongAdapter = ListSongAdapter(list)
        rvSongs.adapter = listSongAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_about -> {
                val moveAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
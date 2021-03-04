package com.thorin.laptopku.view

import android.content.Intent
import android.database.ContentObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thorin.laptopku.R
import com.thorin.laptopku.adapter.RecyclerViewFavLaptopAdapter
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.CONTENT_URI
import com.thorin.laptopku.helper.FavQueryHelper
import com.thorin.laptopku.helper.MappingHelper
import com.thorin.laptopku.model.ListFavorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class LaptopFavActivity : AppCompatActivity() {

    private lateinit var dbHelper: FavQueryHelper
    private lateinit var adapter: RecyclerViewFavLaptopAdapter

    companion object {
        private const val EXTRA_STATE = "extra_state"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laptop_fav)
        val rvRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewFavLaptop)
        dbHelper = FavQueryHelper.getInstance(applicationContext)
        dbHelper.open()

        rvRecyclerView.layoutManager = LinearLayoutManager(this)
        rvRecyclerView.setHasFixedSize(true)
        adapter = RecyclerViewFavLaptopAdapter()
        rvRecyclerView.adapter = adapter

        val handleThread = HandlerThread("DataObserver")
        handleThread.start()
        val handler = Handler(handleThread.looper)
        val myObserver = object : ContentObserver(handler) {
            override fun onChange(selfChange: Boolean) {
                loadFavList()
            }
        }

        contentResolver.registerContentObserver(CONTENT_URI, true, myObserver)
        if (savedInstanceState == null) {
            loadFavList()
        } else {
            val list = savedInstanceState.getParcelableArrayList<ListFavorite>(EXTRA_STATE)
            if (list != null) {
                adapter.listFavorite = list
            }
        }
        if (supportActionBar != null) {
            supportActionBar?.title = getString(R.string.user_fav)
        }
        loadFavList()
    }

    private fun loadFavList() {
        GlobalScope.launch(Dispatchers.Main) {
            val deferredFav = async(Dispatchers.IO) {
                val cursor = contentResolver.query(CONTENT_URI, null, null, null, null)
                cursor?.let { MappingHelper.mapToArrayList(it) }
            }
            val favData = deferredFav.await()
            if (favData?.size!! > 0) {
                adapter.listFavorite = favData
            } else {
                adapter.listFavorite = ArrayList()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_STATE, adapter.listFavorite)
    }

    override fun onResume() {
        super.onResume()
        loadFavList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.fav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> {
                val intent = Intent(this@LaptopFavActivity, LaptopFavActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> return true
        }
    }

}
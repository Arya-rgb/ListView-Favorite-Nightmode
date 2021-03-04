package com.thorin.laptopku.detail

import ListLaptop
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thorin.laptopku.R
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.AVATARLAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.CONTENT_URI
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.HARGALAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.KETLAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.NAMALAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.SPESIFIKASI
import com.thorin.laptopku.helper.FavQueryHelper
import com.thorin.laptopku.model.ListFavorite

class DetailLaptop : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    private lateinit var dbHelper: FavQueryHelper
    private var statFav = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_laptop)

        dbHelper = FavQueryHelper.getInstance(applicationContext)
        dbHelper.open()

        val userVal = intent.getParcelableExtra<ListLaptop>(EXTRA_DETAIL) as ListLaptop
        val cursor: Cursor = dbHelper.queryByUsername(userVal.namaLaptop.toString())
        if (cursor.moveToNext()) {
            statFav = true
            setStatFav(true)
        }

        val namaLaptop: TextView = findViewById(R.id.nama_laptop)
        val hargaLaptop: TextView = findViewById(R.id.harga_laptop)
        val ketLaptop: TextView = findViewById(R.id.ketlaptop)
        val spesifikasi: TextView = findViewById(R.id.spesifikasi)
        val imageLaptop: ImageView = findViewById(R.id.avatar)

        val dataLaptop = intent.getParcelableExtra<ListLaptop>(EXTRA_DETAIL) as ListLaptop

        namaLaptop.text = dataLaptop.namaLaptop
        hargaLaptop.text = dataLaptop.hargaLaptop
        ketLaptop.text = dataLaptop.ketLaptop
        spesifikasi.text = dataLaptop.spesifikasi

        Glide.with(this)
            .load(dataLaptop.avatarLaptop).apply(RequestOptions())
            .error(R.drawable.ic_errror)
            .into(imageLaptop)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = dataLaptop.namaLaptop

        findViewById<FloatingActionButton>(R.id.fab_fav).setOnClickListener {
            val data = intent.getParcelableExtra<ListLaptop>(EXTRA_DETAIL) as ListLaptop
            if (statFav) {
                val idUser = data.namaLaptop.toString()
                dbHelper.deleteById(idUser)
                setStatFav(false)
                statFav = true
            } else {
                val values = ContentValues()
                values.put(NAMALAPTOP, data.namaLaptop)
                values.put(HARGALAPTOP, data.hargaLaptop)
                values.put(KETLAPTOP, data.ketLaptop)
                values.put(SPESIFIKASI, data.spesifikasi)
                values.put(AVATARLAPTOP, data.avatarLaptop)

                statFav = false
                contentResolver.insert(CONTENT_URI, values)
                setStatFav(true)
            }
            this.recreate()
        }

        findViewById<FloatingActionButton>(R.id.fab_share).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val shareBody = "hay, Aku mau merekomendasikan laptop ${dataLaptop.namaLaptop}, ${dataLaptop.ketLaptop}"
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, dataLaptop.namaLaptop)
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, "Mau Share Kemana Nih ?"))
        }
    }

    private fun setStatFav(status: Boolean) {
        val fabFav: FloatingActionButton = findViewById(R.id.fab_fav)
        if (status) {
            fabFav.setImageResource(R.drawable.ic_yesfav)
        } else {
            fabFav.setImageResource(R.drawable.ic_nofav)
        }
    }

}
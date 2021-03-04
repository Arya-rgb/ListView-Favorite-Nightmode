package com.thorin.laptopku.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thorin.laptopku.R
import com.thorin.laptopku.detail.DetailLaptop
import com.thorin.laptopku.detail.DetailLaptopFav
import com.thorin.laptopku.model.ListFavorite

class RecyclerViewFavLaptopAdapter : RecyclerView.Adapter<RecyclerViewFavLaptopAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewFavLaptopAdapter.ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.laptop_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewFavLaptopAdapter.ListViewHolder, position: Int) {
        holder.bind(listFavorite[position])
        val data = listFavorite[position]
        holder.itemView.setOnClickListener{
            val userData = ListFavorite(
                data.namaLaptop,
                data.hargaLaptop,
                data.ketLaptop,
                data.spesifikasi,
                data.avatarLaptop
            )
            val moveIntent = Intent(it.context, DetailLaptopFav::class.java)
            moveIntent.putExtra(DetailLaptopFav.EXTRA_DETAIL_FAV, userData)
            it.context.startActivity(moveIntent)
        }
    }

    override fun getItemCount(): Int = listFavorite.size

    var listFavorite = ArrayList<ListFavorite>()
        set(listFavorite) {
            if (listFavorite.size > 0) {
                this.listFavorite.clear()
            }
            this.listFavorite.addAll(listFavorite)
            notifyDataSetChanged()
        }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val namaLaptop = itemView.findViewById<TextView>(R.id.nama_laptop)
        private val hargaLaptop = itemView.findViewById<TextView>(R.id.harga_laptop)
        private val ketLaptop = itemView.findViewById<TextView>(R.id.ketlaptop)
        private val spesifikasi = itemView.findViewById<TextView>(R.id.spesifikasi)
        private val avatarLaptop = itemView.findViewById<ImageView>(R.id.avatar)

        fun bind(favorite: ListFavorite) {
            Glide.with(itemView.context)
                .load(favorite.avatarLaptop)
                .apply(RequestOptions().override(100,100))
                .error(R.drawable.ic_errror)
                .into(avatarLaptop)
            namaLaptop.text = favorite.namaLaptop
            hargaLaptop.text = favorite.hargaLaptop
            ketLaptop.text = favorite.ketLaptop
            spesifikasi.text = favorite.spesifikasi
        }
    }
}
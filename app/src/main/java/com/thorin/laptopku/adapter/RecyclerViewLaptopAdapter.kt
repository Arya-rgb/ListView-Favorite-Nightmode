package com.thorin.laptopku.adapter

import ListLaptop
import android.content.Context
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

class RecyclerViewLaptopAdapter(val context : Context, var laptopList: ArrayList<ListLaptop>) : RecyclerView.Adapter<RecyclerViewLaptopAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.laptop_item, p0, false)
        return ViewHolder(v);
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.namaLaptop?.text = laptopList[p1].namaLaptop
        p0.hargaLaptop?.text = laptopList[p1].hargaLaptop
        p0.ketLaptop?.text = laptopList[p1].ketLaptop
        p0.spesifikasi?.text = laptopList[p1].spesifikasi
        val uri = laptopList[p1].avatarLaptop
        Glide.with(p0.itemView.context)
            .load(uri)
            .apply(RequestOptions().override(100,100))
            .error(R.drawable.ic_errror)
            .into(p0.avatarLaptop)
        val laptop = laptopList[p1]
        val dataUserIntent = ListLaptop(
                laptop.namaLaptop,
                laptop.hargaLaptop,
                laptop.ketLaptop,
                laptop.spesifikasi,
                laptop.avatarLaptop
        )

        val sLaptop = p0.itemView.context

        p0.itemView.setOnClickListener {
            val moveSpec = Intent(sLaptop, DetailLaptop::class.java)
            moveSpec.putExtra(DetailLaptop.EXTRA_DETAIL, dataUserIntent)
            sLaptop.startActivity(moveSpec)
        }

    }

    override fun getItemCount(): Int {
       return laptopList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaLaptop = itemView.findViewById<TextView>(R.id.nama_laptop)
        val hargaLaptop = itemView.findViewById<TextView>(R.id.harga_laptop)
        val ketLaptop = itemView.findViewById<TextView>(R.id.ketlaptop)
        val spesifikasi = itemView.findViewById<TextView>(R.id.spesifikasi)
        val avatarLaptop = itemView.findViewById<ImageView>(R.id.avatar)

    }

    fun filterList(filteredCourseList: ArrayList<ListLaptop>) {
        this.laptopList = filteredCourseList
        notifyDataSetChanged()
    }

}
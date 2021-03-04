package com.thorin.laptopku.helper

import android.database.Cursor
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.AVATARLAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.HARGALAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.KETLAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.NAMALAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.SPESIFIKASI
import com.thorin.laptopku.model.ListFavorite

object MappingHelper {

    fun mapToArrayList(cursor: Cursor): ArrayList<ListFavorite> {
        val favList = ArrayList<ListFavorite>()

        cursor.apply {
            while (moveToNext()) {
                val namaLaptop = getString(getColumnIndexOrThrow(NAMALAPTOP))
                val hargaLaptop = getString(getColumnIndexOrThrow(HARGALAPTOP))
                val ketLaptop = getString(getColumnIndexOrThrow(KETLAPTOP))
                val spesifikasi = getString(getColumnIndexOrThrow(SPESIFIKASI))
                val avatarLaptop = getString(getColumnIndexOrThrow(AVATARLAPTOP))

                favList.add(
                        ListFavorite(
                                namaLaptop,
                                hargaLaptop,
                                ketLaptop,
                                spesifikasi,
                                avatarLaptop
                        )
                )
            }
        }
        return favList
    }
}
package com.thorin.laptopku.database

import android.net.Uri
import android.provider.BaseColumns

internal class DatabaseContract {

    companion object {
        const val AUTHORITY = "com.thorin.laptopku"
        const val SCHEME = "content"
    }

    internal class FavoriteColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "laptop_favorite"
            const val NAMALAPTOP = "namaLaptop"
            const val HARGALAPTOP = "hargaLaptop"
            const val KETLAPTOP = "ketLaptop"
            const val SPESIFIKASI = "spesifikasi"
            const val AVATARLAPTOP = "avatarLaptop"

            val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME).authority(AUTHORITY).appendPath(TABLE_NAME).build()
        }

    }
}
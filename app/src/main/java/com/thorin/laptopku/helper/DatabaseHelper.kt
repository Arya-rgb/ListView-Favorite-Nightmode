package com.thorin.laptopku.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.AVATARLAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.HARGALAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.KETLAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.NAMALAPTOP
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.SPESIFIKASI
import com.thorin.laptopku.database.DatabaseContract.FavoriteColumns.Companion.TABLE_NAME

internal class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE_FAV)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    companion object {
        private const val DATABASE_NAME = "laptop_fav_db"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_TABLE_FAV = "CREATE TABLE $TABLE_NAME" +
                "($NAMALAPTOP TEXT NOT NULL," +
                "$HARGALAPTOP TEXT NOT NULL," +
                "$KETLAPTOP TEXT NOT NULL," +
                "$SPESIFIKASI TEXT NOT NULL," +
                "$AVATARLAPTOP TEXT NOT NULL)"
    }
}
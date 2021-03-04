package com.thorin.laptopku.view


import ListLaptop
import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.app.SearchManager
import android.content.Intent
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thorin.laptopku.R
import com.thorin.laptopku.adapter.RecyclerViewLaptopAdapter
import com.thorin.laptopku.sharedpref.SharedPrefNightMode
import com.thorin.laptopku.utils.LaptopDataHelper

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class LaptopActivity : AppCompatActivity() {

    lateinit var adapter: RecyclerViewLaptopAdapter
    private lateinit var sharedpref:SharedPrefNightMode

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laptop)

        val rvRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewLaptop)

        rvRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        adapter = RecyclerViewLaptopAdapter(this, LaptopDataHelper.getVersionsList())
        rvRecyclerView.adapter = adapter

        isNightMode()

    }

    fun isNightMode() {
        sharedpref = SharedPrefNightMode(this)
        if (sharedpref.loadNightModeState() === true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.cari)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@LaptopActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }
            override fun onQueryTextChange(text: String): Boolean {
                filter(text)
                return true
            }
        })
        return true
    }

    fun filter(text: String) {

        val filteredCourseAry: ArrayList<ListLaptop> = ArrayList()

        val courseAry : ArrayList<ListLaptop> = LaptopDataHelper.getVersionsList()

        for (eachCourse in courseAry) {
            if (eachCourse.namaLaptop!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.ketLaptop!!.toLowerCase().contains(text.toLowerCase())) {
                filteredCourseAry.add(eachCourse)
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filteredCourseAry)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_fav -> {
                val intent = Intent(this@LaptopActivity, LaptopFavActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_set -> {
                val intent = Intent(this@LaptopActivity, SettingActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_about -> {
                val intent = Intent(this@LaptopActivity, AboutMeActivity::class.java)
                startActivity(intent)
                true
            }
            else -> true
        }
    }
}
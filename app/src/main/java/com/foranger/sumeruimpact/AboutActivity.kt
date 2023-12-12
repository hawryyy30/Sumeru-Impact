package com.foranger.sumeruimpact


import android.annotation.SuppressLint
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foranger.sumeruimpact.databinding.ActivityAboutBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class AboutActivity : AppCompatActivity() {

    lateinit var navigationView : BottomNavigationView
    private lateinit var rvForanger: RecyclerView
    private val foranger_list = ArrayList<com.foranger.sumeruimpact.Foranger>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        navigationView = findViewById(R.id.bottom_navigation)
        navigationView.setSelectedItemId(R.id.nav_chars)

        navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_chars -> {
                    val intent = Intent(this@AboutActivity, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_about -> {
//                    val fragment = AboutFragment()
//                    supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
//                    true

                    val intent = Intent(this@AboutActivity, AboutActivity::class.java)
                    startActivity(intent)
                    true

                }
                else -> false
            }
        }


        rvForanger = findViewById(R.id.list_view_foranger)
        rvForanger.setHasFixedSize(true)

        foranger_list.addAll(getListCharacters())
        showRecyclerList()

    }

    private fun getListCharacters(): Collection<Foranger> {
        val dataPhoto = resources.obtainTypedArray(R.array.foranger_photos)
        val dataNames = resources.getStringArray(R.array.foranger_names)
        val dataEmail = resources.getStringArray(R.array.foranger_email)
        val dataJobDesc = resources.getStringArray(R.array.foranger_jobdesc)

        val listForanger = ArrayList<Foranger>()
        for (i in dataNames.indices) {
            val foranger = Foranger(

                dataPhoto.getResourceId(i, -1),
                dataNames[i],
                dataEmail[i],
                dataJobDesc[i],
            )
            listForanger.add(foranger)
        }

        return listForanger
    }

    private fun showRecyclerList() {

        rvForanger.layoutManager = LinearLayoutManager(this)
        val listForangerAdapter = ListForangerAdapter(foranger_list, rvForanger)
        rvForanger.adapter = listForangerAdapter

    }


}


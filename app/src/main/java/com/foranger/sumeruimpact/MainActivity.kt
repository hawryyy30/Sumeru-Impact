package com.foranger.sumeruimpact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var navigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        navigationView = findViewById(R.id.bottom_navigation)
        supportFragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment()).commit()
        navigationView.setSelectedItemId(R.id.nav_chars)
        navigationView.setOnNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_chars -> fragment = HomeFragment()
                R.id.nav_about -> fragment = AboutFragment()

            }
            supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment!!).commit()
            true
        }
    }
}
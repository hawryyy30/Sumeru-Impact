package com.foranger.sumeruimpact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var nickname: TextView
    private lateinit var portrait: ImageView
    private lateinit var introduction: TextView
    private lateinit var weapon: TextView
    private lateinit var vision: TextView
    private lateinit var constellation: TextView
    private lateinit var affiliation: TextView
    private lateinit var birthday: TextView
    private lateinit var dish: TextView

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NICKNAME = "extra_nickname"
        const val EXTRA_PORTRAIT = "extra_portrait"
        const val EXTRA_INTRODUCTION = "extra_introduction"
        const val EXTRA_WEAPON = "extra_weapon"
        const val EXTRA_VISION = "extra_vision"
        const val EXTRA_AFFILIATION = "extra_affiliation"
        const val EXTRA_CONSTELLATION = "extra_constellation"
        const val EXTRA_BIRTHDAY = "extra_birthday"
        const val EXTRA_DISH = "extra_dish"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val navigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_chars -> {
                    val intent = Intent(this@DetailActivity, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_about -> {
                    val fragment = AboutFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
                    true

                    /*
                    val intent = Intent(this@DetailActivity, AboutActivity::class.java)
                    startActivity(intent)
                    true
                    */
                }
                else -> false
            }
        }

        portrait = findViewById(R.id.img_character_main)

        name = findViewById(R.id.chara_names)
        nickname = findViewById(R.id.chara_nicknames)
        introduction = findViewById(R.id.chara_introduction)
        weapon = findViewById(R.id.chara_weapons)
        vision = findViewById(R.id.chara_visions)
        constellation = findViewById(R.id.chara_constellations)
        affiliation = findViewById(R.id.chara_affiliations)
        birthday = findViewById(R.id.chara_birthdays)
        dish = findViewById(R.id.chara_dishes)

        val portraitResourceId = intent.getIntExtra(EXTRA_PORTRAIT, -1)
        portrait.setImageResource(portraitResourceId)

        name.text = intent.getStringExtra(EXTRA_NAME)
        nickname.text = intent.getStringExtra(EXTRA_NICKNAME)
        introduction.text = intent.getStringExtra(EXTRA_INTRODUCTION)
        weapon.text = intent.getStringExtra(EXTRA_WEAPON)
        vision.text = intent.getStringExtra(EXTRA_VISION)
        constellation.text = intent.getStringExtra(EXTRA_CONSTELLATION)
        affiliation.text = intent.getStringExtra(EXTRA_AFFILIATION)
        birthday.text = intent.getStringExtra(EXTRA_BIRTHDAY)
        dish.text = intent.getStringExtra(EXTRA_DISH)
    }
}


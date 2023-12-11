package com.foranger.sumeruimpact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var photoMain: ImageView
    private lateinit var photoSplash: ImageView
    private lateinit var name: TextView
    private lateinit var nickname: TextView
    private lateinit var description: TextView
    private lateinit var weapon: TextView
    private lateinit var vision: TextView
    private lateinit var constellation: TextView
    private lateinit var affiliation: TextView
    private lateinit var birthday: TextView
    private lateinit var specialDish: TextView

    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_PHOTO_SPLASH = "extra_photo_splash"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NICKNAME = "extra_nickname"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_WEAPON = "extra_weapon"
        const val EXTRA_VISION = "extra_vision"
        const val EXTRA_AFFILIATION = "extra_affiliation"
        const val EXTRA_CONSTELLATION = "extra_constellation"
        const val EXTRA_BIRTHDAY = "extra_birthday"
        const val EXTRA_SPECIAL_DISH = "extra_special_dish"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.title = intent.getStringExtra(EXTRA_NAME)

        photoMain = findViewById(R.id.img_character_main)
        photoSplash = findViewById(R.id.img_character_splash)
        name = findViewById(R.id.chara_names)
        nickname = findViewById(R.id.chara_nicknames)

        weapon = findViewById(R.id.chara_weapons)
        vision = findViewById(R.id.chara_visions)
        constellation = findViewById(R.id.chara_constellations)
        affiliation = findViewById(R.id.chara_affiliations)
        birthday = findViewById(R.id.chara_birthdays)
        specialDish = findViewById(R.id.chara_dishes)

        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_PHOTO))
            .into(photoMain)

        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_PHOTO_SPLASH))
            .into(photoSplash)
        name.text = intent.getStringExtra(EXTRA_NAME)
        nickname.text = intent.getStringExtra(EXTRA_NICKNAME)
        description.text = intent.getStringExtra(EXTRA_DESCRIPTION)
        weapon.text = intent.getStringExtra(EXTRA_WEAPON)
        vision.text = intent.getStringExtra(EXTRA_VISION)
        constellation.text = intent.getStringExtra(EXTRA_CONSTELLATION)
        affiliation.text = intent.getStringExtra(EXTRA_AFFILIATION)
        birthday.text = intent.getStringExtra(EXTRA_BIRTHDAY)
        specialDish.text = intent.getStringExtra(EXTRA_SPECIAL_DISH)


    }
}
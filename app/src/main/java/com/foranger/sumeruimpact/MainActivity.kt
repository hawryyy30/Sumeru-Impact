package com.foranger.sumeruimpact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navigationView : BottomNavigationView

    private lateinit var rvCharacter: RecyclerView
    private val list = ArrayList<com.foranger.sumeruimpact.Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView = findViewById(R.id.bottom_navigation)
        navigationView.setSelectedItemId(R.id.nav_chars)

        navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_chars -> {
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_about -> {
//                    val fragment = AboutFragment()
//                    supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
//                    true

                    val intent = Intent(this@MainActivity, AboutActivity::class.java)
                    startActivity(intent)
                    true

                }
                else -> false
            }
        }

        rvCharacter = findViewById(R.id.rv_characters)
        rvCharacter.setHasFixedSize(true)

        list.addAll(getListCharacters())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_chars -> {
                rvCharacter.layoutManager = LinearLayoutManager(this)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCharacters(): ArrayList<com.foranger.sumeruimpact.Character> {
        val dataName = resources.getStringArray(R.array.chara_names)
        val dataNickname= resources.getStringArray(R.array.chara_nicknames)
        val dataIntroduction = resources.getStringArray(R.array.chara_introduction)
        val dataThumbnail = resources.obtainTypedArray(R.array.chara_thumbnails)
        val dataVisionIcon = resources.obtainTypedArray(R.array.chara_vision_icons)
        val dataQuality = resources.obtainTypedArray(R.array.chara_quality)
        val dataPortrait = resources.obtainTypedArray(R.array.chara_portraits)
        val dataWeapon = resources.getStringArray(R.array.chara_weapons)
        val dataPhotoSplash = resources.getStringArray(R.array.chara_portrait)
        val dataVision = resources.getStringArray(R.array.chara_visions)
        val dataConstellation = resources.getStringArray(R.array.chara_constellations)
        val dataAffiliation = resources.getStringArray(R.array.chara_affiliations)
        val dataBirthday = resources.getStringArray(R.array.chara_birthdays)
        val dataDish = resources.getStringArray(R.array.chara_dishes)
        val listCharacter = ArrayList<Character>()
        for (i in dataName.indices) {
            val character = Character(

                dataName[i],
                dataNickname[i],
                dataIntroduction[i],
                dataThumbnail.getResourceId(i, -1),
                dataVisionIcon.getResourceId(i, -1),
                dataQuality.getResourceId(i, -1),
                dataPortrait.getResourceId(i, -1),
                dataWeapon[i],
                dataPhotoSplash[i],
                dataVision[i],
                dataConstellation[i],
                dataAffiliation[i],
                dataBirthday[i],
                dataDish[i]
            )
            listCharacter.add(character)
        }

        return listCharacter
    }

    private fun showRecyclerList() {
        rvCharacter.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = ListCharacterAdapter(list, rvCharacter)
        rvCharacter.adapter = listCharacterAdapter

        listCharacterAdapter.setOnItemClickCallback(object :
            ListCharacterAdapter.OnItemClickCallback {
            override fun onItemClicked(data: com.foranger.sumeruimpact.Character) {
                showSelectedCharacter(data)
            }
        })
    }

    private fun showSelectedCharacter(character: Character) {
        val characterDetailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        characterDetailIntent.putExtra("extra_name", character.name)
        characterDetailIntent.putExtra("extra_nickname", character.nickname)
        characterDetailIntent.putExtra("extra_thumbnail", character.thumbnail)
        characterDetailIntent.putExtra("extra_vision_icon", character.visionIcon)
        characterDetailIntent.putExtra("extra_quality", character.quality)
        characterDetailIntent.putExtra("extra_portrait", character.portrait)
        characterDetailIntent.putExtra("extra_photo_splash", character.photoSplash)
        characterDetailIntent.putExtra("extra_introduction", character.introduction)
        characterDetailIntent.putExtra("extra_weapon", character.weapon)
        characterDetailIntent.putExtra("extra_vision", character.vision)
        characterDetailIntent.putExtra("extra_constellation", character.constellation)
        characterDetailIntent.putExtra("extra_affiliation", character.affiliation)
        characterDetailIntent.putExtra("extra_birthday", character.birthday)
        characterDetailIntent.putExtra("extra_dish", character.dish)
        startActivity(characterDetailIntent)
//        TODO("go to detail page")
    }
}
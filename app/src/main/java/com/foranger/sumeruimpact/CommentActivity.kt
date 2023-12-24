package com.foranger.sumeruimpact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.android.material.bottomnavigation.BottomNavigationView


class CommentActivity : AppCompatActivity() {

    lateinit var rvComment : RecyclerView
    lateinit var rvLoadingData : TextView
    lateinit var comList: ArrayList<CommentModel>
    lateinit var txt_comment : EditText
    lateinit var btn_comment : Button
    lateinit var database : DatabaseReference
    lateinit var navigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        database = FirebaseDatabase.getInstance().getReference("Komen")
        btn_comment = findViewById(R.id.btn_komen) as Button
        txt_comment = findViewById(R.id.txt_komen)

        rvLoadingData = findViewById(R.id.rvLoadingData)
        rvComment = findViewById(R.id.rvComment)
        rvComment.layoutManager = LinearLayoutManager(this)
        rvComment.setHasFixedSize(true)

        btn_comment.setOnClickListener{
            saveComment()
        }

        comList = arrayListOf<CommentModel>()

        getCommentData()

        navigationView = findViewById(R.id.bottom_navigation)
        navigationView.setSelectedItemId(R.id.nav_comment)

        navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_chars -> {
                    val intent = Intent(this@CommentActivity, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_about -> {

                    val intent = Intent(this@CommentActivity, AboutActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_comment ->{
                    val intent = Intent(this@CommentActivity,CommentActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun getCommentData(){
        rvComment.visibility = View.GONE
        rvLoadingData.visibility = View.VISIBLE

        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                comList.clear()
                if (snapshot.exists()){
                    for (comSnap in snapshot.children){
                        val comData = comSnap.getValue(CommentModel::class.java)
                        comList.add(comData!!)
                    }
                    val mAdapter = CommentAdapter(comList)
                    rvComment.adapter = mAdapter

                    rvComment.visibility = View.VISIBLE
                    rvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun saveComment(){

        val comment = txt_comment.text.toString()

        if (comment.isEmpty()){
            txt_comment.error = "Comment is empty"
        }

        val comId = database.push().key!!

        val comVal = CommentModel(comId, comment)

        database.child(comId).setValue(comVal)
            .addOnCompleteListener{
                Toast.makeText(this, "Your comment inserted successfully", Toast.LENGTH_LONG).show()
                txt_comment.text.clear()
            }.addOnFailureListener { err ->
                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }
}
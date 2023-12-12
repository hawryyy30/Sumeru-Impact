package com.foranger.sumeruimpact

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListForangerAdapter(private val listForanger: ArrayList<Foranger>, public val currentRv: RecyclerView) :
    RecyclerView.Adapter<ListForangerAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgForanger: ImageView = itemView.findViewById(R.id.img_foranger_photo)
        val nameForanger: TextView = itemView.findViewById(R.id.tv_foranger_name)
        val emailForanger: TextView = itemView.findViewById(R.id.tv_foranger_email)
        val JobDescForanger: TextView = itemView.findViewById(R.id.tv_foranger_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.foranger_fragment, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listForanger.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (img, name, email, jobdesc) = listForanger[position]
        holder.imgForanger.setImageResource(img)
        holder.nameForanger.text = name
        holder.emailForanger.text = email
        holder.JobDescForanger.text = jobdesc
        }

    }



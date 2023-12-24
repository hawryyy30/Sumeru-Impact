package com.foranger.sumeruimpact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCharacterAdapter(private val listCharacter: ArrayList<Character>, public val currentRv: RecyclerView) :
    RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Character)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgThumbnail: ImageView = itemView.findViewById(R.id.img_item_photo)
        val nameCharacter: TextView = itemView.findViewById(R.id.tv_item_name)
        val introductionCharacter: TextView = itemView.findViewById(R.id.tv_item_desc)
        val imgVisionIcon: ImageView = itemView.findViewById(R.id.img_item_element)
        val imgQuality: ImageView = itemView.findViewById(R.id.img_item_star)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_fragment, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCharacter.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, nickname, introduction, thumbnail, visionIcon, quality) = listCharacter[position]
        holder.imgThumbnail.setImageResource(thumbnail)
        holder.imgVisionIcon.setImageResource(visionIcon)
        holder.imgQuality.setImageResource(quality)
        holder.nameCharacter.text = name
        holder.introductionCharacter.text = introduction

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listCharacter[holder.adapterPosition]) }
    }
}
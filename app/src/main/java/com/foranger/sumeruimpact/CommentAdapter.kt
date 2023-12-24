package com.foranger.sumeruimpact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter (private val comList : ArrayList<CommentModel>) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.comment_list_item, parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCom = comList[position]
        holder.rvComText.text = currentCom.Comment
    }

    override fun getItemCount(): Int {
        return comList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvComText : TextView = itemView.findViewById(R.id.rvComText)
    }
}
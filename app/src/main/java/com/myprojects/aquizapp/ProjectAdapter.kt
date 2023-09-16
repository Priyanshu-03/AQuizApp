package com.myprojects.aquizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProjectAdapter(private val quizList: ArrayList<Index>): RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>(){

    var onItemClick: ((Index) -> Unit)? = null

    class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.image_view)
        val title: TextView = itemView.findViewById(R.id.text_view_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quiz_cat,parent,false)
        return ProjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val index = quizList[position]
        holder.image.setImageResource(index.img)
        holder.title.text = index.title

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(index)
        }
    }

    override fun getItemCount(): Int {
        return quizList.size
    }

}
package com.miu.resume

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResumeItemsAdapter(private val resumeItems: List<ResumeItem>) :
RecyclerView.Adapter<ResumeItemsAdapter.ResumeItemViewHolder> ()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeItemViewHolder {
        return ResumeItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.resume_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ResumeItemViewHolder, position: Int) {
        holder.bind(resumeItems[position])
    }

    override fun getItemCount(): Int {
        return resumeItems.size
    }

    inner class ResumeItemViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val imageResume = view.findViewById<ImageView>(R.id.imageResume)
        private val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private val textDescription = view.findViewById<TextView>(R.id.textDescription)

        fun bind(resumeItem: ResumeItem){
            imageResume.setImageResource(resumeItem.resumeImage)
            textTitle.text = resumeItem.title
            textDescription.text = resumeItem.description

        }
    }
}
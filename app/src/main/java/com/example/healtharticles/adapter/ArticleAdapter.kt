package com.example.healtharticles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healtharticles.MainActivity
import com.example.healtharticles.R
import com.example.healtharticles.model.Article
import javax.sql.DataSource

public class ArticleAdapter(
        private val dataset : List<Article>,
        private val context: Context,
        private val listener: OnItemClickListener
    ): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    /**
         * Initialize view elements
         */
        inner class ArticleViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
            val imageView: ImageView = view.findViewById(R.id.elementImg)
            val textView: TextView = view.findViewById(R.id.title)
            init{
                view.setOnClickListener(this)
            }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION){
            listener.onItemClick(position)
            }
        }
    }

        override fun getItemCount()= dataset.size

        override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
            val item = dataset[position]
            holder.imageView.setImageResource(item.imageResourceId)
            holder.textView.text=item.title
            val resources = context.resources
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.one_element, parent, false)

        return ArticleViewHolder(adapterLayout)
    }
    interface  OnItemClickListener{
        fun onItemClick(position: Int)
    }
}
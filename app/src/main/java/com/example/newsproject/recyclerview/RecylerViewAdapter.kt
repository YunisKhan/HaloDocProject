package com.example.newsproject.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.R
import com.example.newsproject.model.News
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mCollection: ArrayList<News>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, null)

        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {

        return mCollection?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        val item: News? = mCollection?.get(position)

        item?.let {

            (holder as NewsViewHolder).title.text   = item.title
            holder.author.text                      = item.author
            holder.url.text                         = item.url
        }
    }

    inner class NewsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title: TextView     = view.title
        val author: TextView    = view.author
        val url: TextView       = view.url
    }

    fun submitList(collection: ArrayList<News>) {

        mCollection = collection

        notifyDataSetChanged()
    }
}
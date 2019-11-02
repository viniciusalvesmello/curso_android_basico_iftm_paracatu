package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.R
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.model.News
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.view.viewholder.NewsViewHolder

class NewsAdapter(private val news: News): RecyclerView.Adapter<NewsViewHolder>() {
    
    override fun getItemViewType(position: Int): Int = R.layout.article
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    
    override fun getItemCount(): Int = news.articles.size
    
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(news.articles[position])
}
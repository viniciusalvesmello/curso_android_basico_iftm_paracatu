package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.view.viewholder

import android.net.Uri
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.R
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.model.Article
import kotlinx.android.synthetic.main.article.view.*

class NewsViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    
    fun bind(article: Article) {
        itemView.apply {
            tvArticleTitle.text = article.title
            tvArticleDescription.text = article.description
            Picasso
                .get()
                .load(article.urlToImage)
                .placeholder(R.drawable.news_api)
                .error(R.drawable.news_api)
                .into(ivArticle)
            cvArticle.setOnClickListener {
                if (article.url.isNotEmpty()) {
                    CustomTabsIntent.Builder().build()
                        .launchUrl(this.context, Uri.parse(article.url))
                }
            }
        }
    }
}
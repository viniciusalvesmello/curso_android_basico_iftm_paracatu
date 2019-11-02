package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.repository

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model.NewsData
import io.reactivex.Single

interface NewsRemote {
    fun getNews(filter: String): Single<NewsData>
}
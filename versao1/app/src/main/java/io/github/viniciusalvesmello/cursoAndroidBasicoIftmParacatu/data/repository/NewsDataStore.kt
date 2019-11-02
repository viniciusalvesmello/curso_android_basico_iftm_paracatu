package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.repository

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model.NewsData
import io.reactivex.Single

interface NewsDataStore {
    fun getNews(filter: String): Single<NewsData>
}
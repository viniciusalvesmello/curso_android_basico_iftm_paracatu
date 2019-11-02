package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.repository

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.model.NewsEntity
import io.reactivex.Single

interface NewsRepository {
    fun getNews(filter: String): Single<NewsEntity>
}
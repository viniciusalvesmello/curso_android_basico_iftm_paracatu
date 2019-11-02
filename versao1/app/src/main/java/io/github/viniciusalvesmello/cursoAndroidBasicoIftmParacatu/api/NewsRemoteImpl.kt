package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.mapper.toNewsData
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model.NewsData
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.repository.NewsRemote
import io.reactivex.Single
import javax.inject.Inject

class NewsRemoteImpl @Inject constructor(private val service: NewsService) : NewsRemote {
    
    override fun getNews(filter: String): Single<NewsData> =
        service.getNews(filter).map {
            it.toNewsData()
        }
}
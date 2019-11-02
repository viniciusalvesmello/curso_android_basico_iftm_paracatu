package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.source

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model.NewsData
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.repository.NewsDataStore
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.repository.NewsRemote
import io.reactivex.Single
import javax.inject.Inject

class NewsRemoteDataStore @Inject constructor(private val remote: NewsRemote): NewsDataStore {
    
    override fun getNews(filter: String): Single<NewsData> =
        remote.getNews(filter)
}
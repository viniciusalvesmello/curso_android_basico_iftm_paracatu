package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.mapper.toNewsEntity
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.source.NewsDataStoreFactory
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.model.NewsEntity
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

class NewsDataRepository @Inject constructor(private val factory: NewsDataStoreFactory): NewsRepository {
    
    override fun getNews(filter: String): Single<NewsEntity> =
        factory.retrieveRemoteDataStore().getNews(filter).map {
            it.toNewsEntity()
        }
}
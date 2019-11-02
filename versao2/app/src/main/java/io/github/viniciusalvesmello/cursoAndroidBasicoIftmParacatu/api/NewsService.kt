package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.model.NewsResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    
    @GET("everything")
    fun getNews(
        @Query("q") filter: String
    ): Single<NewsResponseModel>
}
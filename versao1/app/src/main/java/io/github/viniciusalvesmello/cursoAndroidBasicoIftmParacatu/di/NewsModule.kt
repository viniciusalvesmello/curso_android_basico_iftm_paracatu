package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.di

import dagger.Module
import dagger.Provides
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.NewsRemoteImpl
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.NewsService
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.NewsDataRepository
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.repository.NewsRemote
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.source.NewsDataStoreFactory
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.repository.NewsRepository
import retrofit2.Retrofit

@Module
class NewsModule {
    
    @Provides
    fun provideNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)
    
    @Provides
    fun provideNewsRemote(service: NewsService): NewsRemote = NewsRemoteImpl(service)
    
    @Provides
    fun provideNesRepository(factory: NewsDataStoreFactory): NewsRepository =
        NewsDataRepository(factory)
    
}
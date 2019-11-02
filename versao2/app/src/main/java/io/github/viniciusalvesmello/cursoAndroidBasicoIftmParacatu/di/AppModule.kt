package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.AppApplication
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.BuildConfig
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.util.extension.isConnected
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule(private val application: AppApplication) {
    
    @Provides
    @Singleton
    fun provideAppApplicationContext(): Context = application
    
    @Provides
    @Named("SchedulersIO")
    fun provideSchedulersIO(): Scheduler = Schedulers.io()
    
    @Provides
    @Named("AndroidSchedulersMainThread")
    fun provideAndroidSchedulersMainThread(): Scheduler = AndroidSchedulers.mainThread()
    
    @Provides
    @Named("CompositeDisposable")
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
    
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.NewsApiUrl)
        .client(createOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
    
    private fun createOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .readTimeout(TIME_OUT_30_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT_30_SECONDS, TimeUnit.SECONDS)
            .cache(Cache(application.cacheDir, CACHE_SIZE_5_MEGA_BYTES))
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().addHeader(
                        "Authorization",
                        "Bearer ${BuildConfig.NewsApiToken}"
                    ).build()
                )
            }
        if (BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }
        return okHttpClientBuilder.build()
    }
    
    companion object {
        private const val TIME_OUT_30_SECONDS = 30.toLong()
        private const val CACHE_SIZE_5_MEGA_BYTES = (5 * 1024 * 1024).toLong()
        private const val CACHE_TIME_ON_LINE_ONE_HOUR_IN_SECONDS = (60 * 60)
        private const val CACHE_OFF_LINE_SEVEN_DAYS_IN_SECONDS = (60 * 60 * 24 * 7)
    }
}
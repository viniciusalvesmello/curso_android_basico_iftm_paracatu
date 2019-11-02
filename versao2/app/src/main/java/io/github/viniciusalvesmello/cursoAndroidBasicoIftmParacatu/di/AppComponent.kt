package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.di

import dagger.Component
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.AppApplication
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.viewmodel.NewsViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NewsModule::class
    ]
)
interface AppComponent {
    fun inject(application: AppApplication)
    fun inject(newsViewModel: NewsViewModel)
}
package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.AppApplication
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.interactor.GetNewsUseCase
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.mapper.toNews
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.model.News
import javax.inject.Inject

class NewsViewModel : ViewModel() {
    
    init {
        AppApplication.appComponent.inject(this)
    }
    
    @Inject
    lateinit var getNewsUseCase: GetNewsUseCase
    
    private var _news: MutableLiveData<News> = MutableLiveData()
    val news: LiveData<News>
        get() = _news
    
    private var _error: MutableLiveData<Throwable> = MutableLiveData()
    val error: LiveData<Throwable>
        get() = _error
    
    fun getNews(filter: String) {
        getNewsUseCase.execute(filter, {
            _news.value = it.toNews()
        }, {
            _error.value = it
        })
    }
}
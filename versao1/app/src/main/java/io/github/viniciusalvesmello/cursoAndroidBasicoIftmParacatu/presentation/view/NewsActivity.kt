package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.R
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    
    private val viewModel: NewsViewModel by lazy {
        ViewModelProviders.of(this).get(NewsViewModel::class.java)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        
        initObservers()
        viewModel.getNews(INIT_FILTER)
    }
    
    
    private fun initObservers() {

        viewModel.news.observe(this, Observer {
            val message =  "${getString(R.string.start_message_success)} ${it.articles.size}"
            textView.text = message
        })
    
        viewModel.error.observe(this, Observer {
            val message =  "${getString(R.string.start_message_error)} ${it.message}"
            textView.text = message
        })
    }
    
    companion object {
        private const val INIT_FILTER = "bitcoin"
    }
}

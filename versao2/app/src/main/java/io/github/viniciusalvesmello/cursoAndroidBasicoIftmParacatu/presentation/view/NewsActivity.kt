package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.R
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.view.adapter.NewsAdapter
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.viewmodel.NewsViewModel
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.util.extension.hideKeyboard
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    
    private val viewModel: NewsViewModel by lazy {
        ViewModelProviders.of(this).get(NewsViewModel::class.java)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        
        initObservers()
        initListeners()
        initView()
    }
    
    private fun initObservers() {
        
        viewModel.news.observe(this, Observer {
            if (it.articles.isNotEmpty()) {
                rvNews.visibility = View.VISIBLE
                rvNews.adapter = NewsAdapter(it)
            } else {
                rvNews.visibility = View.INVISIBLE
                Toast.makeText(
                    this,
                    getString(R.string.erro_no_data_found),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        
        viewModel.error.observe(this, Observer {
            Toast.makeText(
                this,
                getString(R.string.error_load_data_from_api),
                Toast.LENGTH_LONG
            ).show()
        })
    }
    
    private fun initListeners() {
        
        etFilter.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            
            }
            
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            
            }
            
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tilFilter.error = ""
                rvNews.visibility = View.INVISIBLE
            }
        })
        
        btnFind.setOnClickListener {
            val filter = etFilter.text.toString()
            if (filter.isEmpty()) {
                tilFilter.error = "Antes de consultar, informe o filtro!"
            } else {
                tilFilter.error = ""
                hideKeyboard()
                viewModel.getNews(filter)
            }
        }
    }
    
    private fun initView() {
        rvNews.visibility = View.INVISIBLE
        rvNews.layoutManager = LinearLayoutManager(this)
    }
}

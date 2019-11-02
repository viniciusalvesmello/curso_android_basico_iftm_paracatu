package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.model

data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
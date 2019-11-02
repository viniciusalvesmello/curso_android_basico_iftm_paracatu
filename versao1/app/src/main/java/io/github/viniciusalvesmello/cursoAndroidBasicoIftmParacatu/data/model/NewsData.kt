package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model

data class NewsData(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleData>
)
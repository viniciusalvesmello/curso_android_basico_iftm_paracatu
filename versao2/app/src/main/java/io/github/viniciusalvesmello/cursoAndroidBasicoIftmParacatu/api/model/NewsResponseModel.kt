package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.model

data class NewsResponseModel(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleResponseModel>
)
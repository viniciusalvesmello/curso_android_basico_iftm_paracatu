package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.model

data class ArticleResponseModel(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
)
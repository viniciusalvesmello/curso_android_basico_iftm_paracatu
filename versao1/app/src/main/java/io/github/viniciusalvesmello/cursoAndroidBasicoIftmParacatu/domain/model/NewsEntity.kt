package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.model

data class NewsEntity(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleEntity>
)
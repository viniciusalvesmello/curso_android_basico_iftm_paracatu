package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.mapper

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model.ArticleData
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model.NewsData
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.model.ArticleEntity
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.model.NewsEntity


fun ArticleData.toArticleEntity(): ArticleEntity = ArticleEntity(
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage
)

fun NewsData.toNewsEntity(): NewsEntity = NewsEntity(
    status = status,
    totalResults = totalResults,
    articles = articles.map {
        it.toArticleEntity()
    }
)
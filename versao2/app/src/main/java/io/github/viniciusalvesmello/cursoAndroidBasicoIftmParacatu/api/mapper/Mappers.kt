package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.mapper

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.model.ArticleResponseModel
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.api.model.NewsResponseModel
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model.ArticleData
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.model.NewsData

fun ArticleResponseModel.toArticleData(): ArticleData = ArticleData(
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage
)

fun NewsResponseModel.toNewsData(): NewsData = NewsData(
    status = status,
    totalResults = totalResults,
    articles = articles.map {
        it.toArticleData()
    }
)
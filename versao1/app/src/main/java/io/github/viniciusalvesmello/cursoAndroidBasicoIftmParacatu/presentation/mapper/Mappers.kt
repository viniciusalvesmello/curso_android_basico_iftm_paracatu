package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.mapper

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.model.ArticleEntity
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.model.NewsEntity
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.model.Article
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.presentation.model.News

fun ArticleEntity.toArticle(): Article = Article(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage
)

fun NewsEntity.toNews(): News = News(
    status = status,
    totalResults = totalResults,
    articles = articles.map {
        it.toArticle()
    }
)
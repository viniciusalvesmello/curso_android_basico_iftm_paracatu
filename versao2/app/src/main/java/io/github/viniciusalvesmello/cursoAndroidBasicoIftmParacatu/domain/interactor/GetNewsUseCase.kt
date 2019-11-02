package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.interactor

import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.model.NewsEntity
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.domain.repository.NewsRepository
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.util.useCase.SingleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

open class GetNewsUseCase @Inject constructor(
    val repository: NewsRepository,
    @Named("SchedulersIO") ioThread: Scheduler,
    @Named("AndroidSchedulersMainThread") androidMainThread: Scheduler,
    @Named("CompositeDisposable") disposables: CompositeDisposable
) : SingleUseCase<NewsEntity, String>(
    ioThread,
    androidMainThread,
    disposables
) {
    
    override fun buildUseCaseObservable(params: String): Single<NewsEntity> =
        repository.getNews(params)
}
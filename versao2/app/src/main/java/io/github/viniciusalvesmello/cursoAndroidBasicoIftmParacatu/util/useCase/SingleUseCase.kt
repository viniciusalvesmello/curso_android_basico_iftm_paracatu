package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.util.useCase

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class SingleUseCase<T, in Params> constructor(
    private val ioThread: Scheduler,
    private val androidMainThread: Scheduler,
    private val disposables: CompositeDisposable
) {
    abstract fun buildUseCaseObservable(params: Params): Single<T>
    
    open fun execute(
        params: Params,
        onSuccess: (T) -> Unit,
        onError: (e: Throwable) -> Unit
    ) {
        
        val single = this.buildUseCaseObservable(params)
            .subscribeOn(ioThread)
            .observeOn(androidMainThread) as Single<T>
        addDisposable(
            single.subscribe(
                { t: T ->
                    onSuccess.invoke(t)
                },
                { error ->
                    onError.invoke(error)
                })
        )
    }
    
    open fun execute(
        params: Params,
        onRequest: () -> Unit,
        onSuccess: (T) -> Unit,
        onError: (e: Throwable) -> Unit
    ) {
        
        val single = this.buildUseCaseObservable(params)
            .subscribeOn(ioThread)
            .observeOn(androidMainThread) as Single<T>
        addDisposable(
            single
                .doOnSubscribe {
                    onRequest.invoke()
                }
                .subscribe(
                    { t: T ->
                        onSuccess.invoke(t)
                    },
                    { error ->
                        onError.invoke(error)
                    })
        
        )
    }
    
    fun dispose() {
        disposables.clear()
    }
    
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}
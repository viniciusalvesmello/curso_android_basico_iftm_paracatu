package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.data.source

import javax.inject.Inject

class NewsDataStoreFactory @Inject constructor(private val newsRemoteDataStore: NewsRemoteDataStore) {
    
    fun retrieveRemoteDataStore(): NewsRemoteDataStore = newsRemoteDataStore
}
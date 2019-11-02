package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu

import android.app.Application
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.di.AppComponent
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.di.AppModule
import io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.di.DaggerAppComponent

class AppApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }
    
    companion object {
        lateinit var appComponent: AppComponent
    }
}
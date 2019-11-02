package io.github.viniciusalvesmello.cursoAndroidBasicoIftmParacatu.util.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun Context.networkInfo(): NetworkInfo? = (
    this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    ).activeNetworkInfo

fun Context.isConnected() = this.networkInfo()?.isConnected ?: false
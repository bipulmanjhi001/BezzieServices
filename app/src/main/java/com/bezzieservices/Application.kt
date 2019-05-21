package com.maasuniva

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun setConnectivityListener(listener: ConnectivityReceiver.ConnectivityReceiverListener) {
        ConnectivityReceiver.connectivityReceiverListener = listener
    }

    companion object {

        @get:Synchronized
        var instance: Application? = null
            private set
    }
}
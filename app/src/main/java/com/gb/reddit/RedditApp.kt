package com.gb.reddit

import android.app.Application
import com.gb.reddit.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class RedditApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RedditApp)
            modules(listOf(appModule))
        }
    }
}
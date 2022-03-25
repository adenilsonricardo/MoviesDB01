package com.example.moviesdb01.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(appDeclaration = KoinAppDeclarationProvider.get(this))
    }
}
object KoinAppDeclarationProvider {
    @Suppress("LongMethod")
    fun get(application: Application): KoinAppDeclaration = {
        androidContext(application)
        MoviesModule().load()
    }
}
package com.gb.reddit.koin

import com.gb.reddit.BuildConfig
import com.gb.reddit.data.repository.HotRepository
import com.gb.reddit.data.repository.HotRepositoryImpl
import com.gb.reddit.data.retrofit.HotApi
import com.gb.reddit.presentation.HotViewModelImpl
import com.gb.reddit.presentation.recycler_view.HotAdapter
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { provideHotApi() }
    single<HotRepository> { HotRepositoryImpl(hotApi = get()) }
    viewModel { HotViewModelImpl(repository = get()) }
    factory{ HotAdapter()}
}

fun provideHotApi(): HotApi =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
        .create(HotApi::class.java)

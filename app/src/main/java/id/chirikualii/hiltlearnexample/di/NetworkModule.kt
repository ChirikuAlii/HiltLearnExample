package id.chirikualii.hiltlearnexample.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import id.chirikualii.hiltlearnexample.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideGsonBuilder() :Gson{
        return Gson()
    }

    @Singleton
    @Provides
    fun provideRetorfit(gson: Gson) : Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) :ApiService{
        return retrofit.create(ApiService::class.java)
    }
}
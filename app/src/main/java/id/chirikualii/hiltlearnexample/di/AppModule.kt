package id.chirikualii.hiltlearnexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import id.chirikualii.hiltlearnexample.data.local.dao.ArticleDao
import id.chirikualii.hiltlearnexample.data.local.mapper.ArticleCacheMapper
import id.chirikualii.hiltlearnexample.data.remote.ApiService
import id.chirikualii.hiltlearnexample.data.remote.mapper.ArticleResponseMapper
import id.chirikualii.hiltlearnexample.data.repo.HeadlineRepo
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideHeadlineRepository(
        service: ApiService,
        articleDao: ArticleDao,
        articleResponseMapper: ArticleResponseMapper,
        articleCacheMapper: ArticleCacheMapper
    ) : HeadlineRepo = HeadlineRepo(service, articleDao, articleResponseMapper, articleCacheMapper)
}
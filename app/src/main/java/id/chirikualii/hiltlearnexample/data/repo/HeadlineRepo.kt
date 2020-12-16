package id.chirikualii.hiltlearnexample.data.repo

import android.util.Log
import com.google.gson.Gson
import id.chirikualii.hiltlearnexample.data.local.dao.ArticleDao
import id.chirikualii.hiltlearnexample.data.local.entity.ArticleCacheEntity
import id.chirikualii.hiltlearnexample.data.local.mapper.ArticleCacheMapper
import id.chirikualii.hiltlearnexample.data.model.Article
import id.chirikualii.hiltlearnexample.data.remote.ApiService
import id.chirikualii.hiltlearnexample.data.remote.mapper.ArticleResponseMapper
import id.chirikualii.hiltlearnexample.data.remote.response.ArticleResponse
import id.chirikualii.hiltlearnexample.data.remote.response.TopHeadlineResponse
import id.chirikualii.hiltlearnexample.utils.mvvm.StateRepository
import javax.inject.Inject


class HeadlineRepo constructor(
        private val service: ApiService,
        private val articleDao :ArticleDao,
        private val articleResponseMapper: ArticleResponseMapper,
        private val articleCacheMapper :ArticleCacheMapper
):StateRepository(){

    suspend fun getHeadlineNewsRemote() : TopHeadlineResponse{
        Log.d(HeadlineRepo::class.java.simpleName,"get headline remote ${Gson().toJsonTree(service.getTopHeadlines().body())}")

        return safeApiRequest {
            val result = service.getTopHeadlines()
            result.body()?.articles
                ?.map { articleResponseMapper.mapFromEntity(it)  }
                ?.forEach { articleDao.addArticle(articleCacheMapper.mapToEntity(it)) }

            result
        }
    }

    suspend fun getHeadlineNewsLocal() :List<Article>{
        Log.d(HeadlineRepo::class.java.simpleName,"get headline local")
        val result = articleDao.loadArticle()
        return result.map { articleCacheMapper.mapFromEntity(it) }

    }
}
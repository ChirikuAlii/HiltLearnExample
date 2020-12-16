package id.chirikualii.hiltlearnexample.data.repo

import id.chirikualii.hiltlearnexample.data.model.Article
import id.chirikualii.hiltlearnexample.data.remote.response.TopHeadlineResponse

interface IHeadlineRepo {

    suspend fun getHeadlineNewsRemote() :TopHeadlineResponse
    suspend fun getHeadlineNewsLocal() :List<Article>
}
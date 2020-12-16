package id.chirikualii.hiltlearnexample.data.remote

import id.chirikualii.hiltlearnexample.data.remote.response.TopHeadlineResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=us&apiKey=452a8b968c514facb39fd8fff27381bb")
    suspend fun getTopHeadlines() : Response<TopHeadlineResponse>
}
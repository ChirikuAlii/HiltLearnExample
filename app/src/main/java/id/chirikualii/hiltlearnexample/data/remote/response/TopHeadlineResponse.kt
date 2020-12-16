package id.chirikualii.hiltlearnexample.data.remote.response

import com.google.gson.annotations.SerializedName
import id.chirikualii.hiltlearnexample.data.model.Article
import id.chirikualii.hiltlearnexample.data.remote.mapper.ArticleResponseMapper

import id.chirikualii.hiltlearnexample.data.remote.response.ArticleResponse
import javax.inject.Inject


data class TopHeadlineResponse(

        @SerializedName("articles")
        val articles: List<ArticleResponse> = listOf(),

        @SerializedName("status")
        val status: String = "",

        @SerializedName("totalResults")
        val totalResults: Int = 0
){

}

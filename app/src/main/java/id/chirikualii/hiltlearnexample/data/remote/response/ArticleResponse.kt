package id.chirikualii.hiltlearnexample.data.remote.response

import com.google.gson.annotations.SerializedName
import id.chirikualii.hiltlearnexample.data.model.Article
import id.chirikualii.hiltlearnexample.utils.EntityMapper


data class ArticleResponse(

        @SerializedName("author")
        var author: String = "",

        @SerializedName("content")
        var content: Any = Any(),

        @SerializedName("description")
        var description: String = "",

        @SerializedName("articles")
        var publishedAt: String = "",

        @SerializedName("title")
        var title: String = "",

        @SerializedName("url")
        var url: String = "",

        @SerializedName("urlToImage")
        var urlToImage: String = ""
)
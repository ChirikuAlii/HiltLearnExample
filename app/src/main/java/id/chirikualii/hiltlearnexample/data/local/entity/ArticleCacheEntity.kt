package id.chirikualii.hiltlearnexample.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "article")
data class ArticleCacheEntity(

        @ColumnInfo(name = "author")
        var author: String?,

        @ColumnInfo(name = "content")
        var content: String?,

        @ColumnInfo(name = "description")
        var description: String?,

        @PrimaryKey
        @ColumnInfo(name = "publishedAt")
        var publishedAt: String,

        @ColumnInfo(name = "title")
        var title: String?,

        @ColumnInfo(name = "url")
        var url: String?,

        @ColumnInfo(name = "urlToImage")
        var urlToImage: String?
)
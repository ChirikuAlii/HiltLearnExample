package id.chirikualii.hiltlearnexample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.chirikualii.hiltlearnexample.data.local.entity.ArticleCacheEntity

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticle(articleEntity: ArticleCacheEntity)

    @Query("SELECT * FROM article")
    suspend fun loadArticle() : List<ArticleCacheEntity>
}

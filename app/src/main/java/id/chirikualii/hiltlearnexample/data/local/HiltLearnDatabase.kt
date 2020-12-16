package id.chirikualii.hiltlearnexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import id.chirikualii.hiltlearnexample.data.local.dao.ArticleDao
import id.chirikualii.hiltlearnexample.data.local.entity.ArticleCacheEntity


@Database(entities = [ArticleCacheEntity::class],version = 1)
abstract class HiltLearnDatabase :RoomDatabase(){

    companion object{
        val DATABASE_NAME = "hilt_learn_db"
    }

    abstract fun articleDao(): ArticleDao
}
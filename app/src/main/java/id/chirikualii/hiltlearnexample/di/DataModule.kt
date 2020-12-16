package id.chirikualii.hiltlearnexample.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import id.chirikualii.hiltlearnexample.data.local.HiltLearnDatabase
import id.chirikualii.hiltlearnexample.data.local.dao.ArticleDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideHiltLearnDb(@ApplicationContext context: Context) :HiltLearnDatabase{
        return Room.databaseBuilder(
                context,
                HiltLearnDatabase::class.java,
                HiltLearnDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideArticleDao(db:HiltLearnDatabase) :ArticleDao{
        return db.articleDao()
    }
}
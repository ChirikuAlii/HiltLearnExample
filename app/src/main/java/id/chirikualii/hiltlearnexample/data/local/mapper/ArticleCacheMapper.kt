package id.chirikualii.hiltlearnexample.data.local.mapper

import id.chirikualii.hiltlearnexample.data.local.entity.ArticleCacheEntity
import id.chirikualii.hiltlearnexample.data.model.Article
import id.chirikualii.hiltlearnexample.utils.EntityMapper
import javax.inject.Inject


class ArticleCacheMapper @Inject constructor() :EntityMapper<ArticleCacheEntity,Article>{

    override fun mapFromEntity(entity: ArticleCacheEntity): Article {
        return Article(
                author = entity.author,
                content = entity.content ,
                description = entity.description,
                publishedAt = entity.publishedAt,
                title =  entity.title,
                url = entity.url,
                urlToImage =entity.urlToImage
        )
    }

    override fun mapToEntity(domainModel: Article): ArticleCacheEntity {
        return ArticleCacheEntity(
                id = 0,
                author = domainModel.author,
                content = domainModel.content.toString(),
                description = domainModel.description,
                publishedAt = domainModel.publishedAt,
                title = domainModel.title,
                url = domainModel.url,
                urlToImage = domainModel.urlToImage
        )
    }

}
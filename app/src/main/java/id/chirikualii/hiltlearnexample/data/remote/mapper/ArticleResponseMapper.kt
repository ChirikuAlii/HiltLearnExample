package id.chirikualii.hiltlearnexample.data.remote.mapper

import id.chirikualii.hiltlearnexample.data.model.Article
import id.chirikualii.hiltlearnexample.data.remote.response.ArticleResponse
import id.chirikualii.hiltlearnexample.utils.EntityMapper
import javax.inject.Inject


class ArticleResponseMapper @Inject constructor() :EntityMapper<ArticleResponse,Article>{

    override fun mapFromEntity(entity: ArticleResponse): Article {
        return Article(
                author =entity.author,
                content = entity.content,
                description = entity.description,
                publishedAt = entity.publishedAt,
                title = entity.title,
                url = entity.url,
                urlToImage = entity.urlToImage
        )
    }

    override fun mapToEntity(domainModel: Article): ArticleResponse {
        return ArticleResponse(
                author =domainModel.author,
                content = domainModel.content,
                description = domainModel.description,
                publishedAt = domainModel.publishedAt,
                title = domainModel.title,
                url = domainModel.url,
                urlToImage = domainModel.urlToImage
        )
    }

    fun mapFromEntityList(entities:List<ArticleResponse>) :List<Article>{
        return entities.map {mapFromEntity(it) }
    }


}
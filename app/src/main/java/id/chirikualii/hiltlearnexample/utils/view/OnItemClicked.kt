package info.chirikualii.newsapi_coroutine.utils.view

import id.chirikualii.hiltlearnexample.data.model.Article


/**
 * Created by chirikuAlii on 26/06/2020.
 * github.com/chirikualii
 */

interface OnItemClicked {

    fun onArticleClicked(article: Article){}
}
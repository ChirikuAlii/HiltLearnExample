package id.chirikualii.hiltlearnexample.ui

import id.chirikualii.hiltlearnexample.data.model.Article


sealed class MainState {
    data class OnShowHeadline(val listData :List<Article>) : MainState()
    data class OnLoading(val isLoading :Boolean =false) : MainState()
}
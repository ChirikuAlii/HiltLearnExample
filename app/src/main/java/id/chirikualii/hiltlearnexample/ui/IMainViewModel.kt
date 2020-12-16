package id.chirikualii.hiltlearnexample.ui

import java.lang.Exception

interface IMainViewModel {

    fun doLoadHeadline()
    fun handleErrorLoadHeadline(e:Exception)
    fun doLoadHeadlineLocal()
}
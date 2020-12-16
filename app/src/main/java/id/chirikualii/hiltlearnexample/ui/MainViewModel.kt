package id.chirikualii.hiltlearnexample.ui

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import id.chirikualii.hiltlearnexample.data.repo.HeadlineRepo
import id.chirikualii.hiltlearnexample.utils.ApiException
import id.chirikualii.hiltlearnexample.utils.NoInternetException
import id.chirikualii.hiltlearnexample.utils.mvvm.StateViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel @ViewModelInject constructor(
        private val repo: HeadlineRepo,
        @Assisted private val savedStateHandle: SavedStateHandle) :StateViewModel<MainState>(),IMainViewModel{

    override fun doLoadHeadline(){
        viewModelScope.launch (Dispatchers.IO){

            try {

                Log.d(TAG,"do load headline ")
                val result = repo.getHeadlineNewsRemote()
                        .let { repo.getHeadlineNewsLocal() }

                state.postValue(MainState.OnShowHeadline(result))

                Log.d(TAG,"success load headline ${Gson().toJsonTree(result)}")
            }catch (e:Exception){ handleErrorLoadHeadline(e) }
        }

    }

    override fun handleErrorLoadHeadline(e: Exception) {
        when(e){

            is ApiException -> {
                Log.e(TAG,"error load headline api exception ${e.message}")
            }
            is NoInternetException -> {
                Log.e(TAG,"error load headline no internet ${e.message}")
            }

            else -> {
                Log.e(TAG,"error load headline ${e.message}")
            }

        }
        doLoadHeadlineLocal()
    }

    override fun doLoadHeadlineLocal() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d(TAG,"do load headline local")

                val result = repo.getHeadlineNewsLocal()
                state.postValue(MainState.OnShowHeadline(result))

                Log.d(TAG,"succes load headline local")
            }catch (e:Throwable){
                Log.d(TAG,"error load headline local ${e.message}")
            }
        }

    }
}
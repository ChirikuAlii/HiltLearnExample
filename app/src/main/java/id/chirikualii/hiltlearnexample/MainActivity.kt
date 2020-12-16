package id.chirikualii.hiltlearnexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import id.chirikualii.hiltlearnexample.ui.MainState
import id.chirikualii.hiltlearnexample.ui.MainViewModel
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),Observer<MainState> {

    private val mViewModel :MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel.state.observe(this,this)

        mViewModel.doLoadHeadline()

    }

    override fun onChanged(state: MainState?) {
        when(state){

            is MainState.OnLoading ->{

            }

            is MainState.OnShowHeadline-> {
                Log.d(MainActivity::class.java.simpleName,"show headline ${Gson().toJsonTree(state.listData)}")
            }
        }
    }
}



package id.chirikualii.hiltlearnexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import id.chirikualii.hiltlearnexample.data.model.Article
import id.chirikualii.hiltlearnexample.databinding.ActivityMainBinding
import id.chirikualii.hiltlearnexample.ui.HeadlineListAdapter
import id.chirikualii.hiltlearnexample.ui.MainState
import id.chirikualii.hiltlearnexample.ui.MainViewModel
import info.chirikualii.newsapi_coroutine.utils.view.OnItemClicked
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),Observer<MainState>,OnItemClicked {

    private val mViewModel :MainViewModel by viewModels()
    lateinit var headlineListAdapter: HeadlineListAdapter
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewModel.state.observe(this,this)
        mViewModel.doLoadHeadline()
        setupView()
    }

    private fun setupView() {
        headlineListAdapter = HeadlineListAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = headlineListAdapter
    }

    override fun onChanged(state: MainState?) {
        when(state){

            is MainState.OnLoading ->{

            }

            is MainState.OnShowHeadline-> {
                Log.d(MainActivity::class.java.simpleName,"show headline ${Gson().toJsonTree(state.listData)}")
                val arrayList = arrayListOf<Article>()
                arrayList.addAll(state.listData)
                headlineListAdapter.addList(arrayList)

            }
        }
    }

    override fun onArticleClicked(article: Article) {
        super.onArticleClicked(article)

    }
}



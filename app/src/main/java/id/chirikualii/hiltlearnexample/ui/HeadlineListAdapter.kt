package id.chirikualii.hiltlearnexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.chirikualii.hiltlearnexample.R
import id.chirikualii.hiltlearnexample.data.model.Article
import id.chirikualii.hiltlearnexample.databinding.ItemArticleBinding
import id.chirikualii.hiltlearnexample.utils.timeMillisToDateTime
import info.chirikualii.newsapi_coroutine.utils.view.OnItemClicked
import java.text.SimpleDateFormat
import kotlinx.android.synthetic.main.item_article.view.*

class HeadlineListAdapter(val onItemClicked: OnItemClicked) : RecyclerView.Adapter<HeadlineListAdapter.HeadlineHolder>(){

    var items : ArrayList<Article> = arrayListOf()
    var listDataFiltered : ArrayList<Article> = arrayListOf()

    class HeadlineHolder(view: View) : RecyclerView.ViewHolder(view)


    fun addList(listData :ArrayList<Article>){
        val oldList = items
        val diffResult : DiffUtil.DiffResult = DiffUtil.calculateDiff(HeadlineListDiffCallback(
            oldList,listData
        ))

        items = listData
        listDataFiltered = listData
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent,false)
        return HeadlineHolder(view)
    }

    override fun getItemCount(): Int {
        return listDataFiltered.size
    }

    override fun onBindViewHolder(holder: HeadlineHolder, position: Int) {
        val binding = ItemArticleBinding.bind(holder.itemView)
        val data = listDataFiltered[position]
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(data.publishedAt)

        binding.tvTitleArticle.text =data.title
        binding.tvDate.text = "Published at ${date.time.timeMillisToDateTime()}"


        Glide.with(holder.itemView.context)
            .load(data.urlToImage)
            .into(binding.ivArticle)

        binding.root.setOnClickListener { onItemClicked.onArticleClicked(data) }


    }

    class HeadlineListDiffCallback(
        var oldList : ArrayList<Article>,
        var newList : ArrayList<Article>
    ): DiffUtil.Callback(){
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return (oldList[oldItemPosition].title == newList[newItemPosition].title)
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].equals(newList[newItemPosition])
        }

    }
}
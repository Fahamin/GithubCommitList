package com.fahim.githubcommitlist.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fahim.githubcommitlist.model.Item
import com.fahim.githubcommitlist.databinding.CommitAdapterItemBinding

class CommitPagerAdapter :
    PagingDataAdapter<Item, CommitPagerAdapter.CommitViewHolder>(CommitComparator) {


    override fun onBindViewHolder(holder: CommitViewHolder, position: Int) {
        val item = getItem(position)
        holder.view.tvSha.text = item?.comments_url
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CommitAdapterItemBinding.inflate(inflater, parent, false)
        return CommitViewHolder(binding)
    }

    class CommitViewHolder(val view: CommitAdapterItemBinding) : RecyclerView.ViewHolder(view.root)

    object CommitComparator : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.node_id == newItem.node_id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }
}
package com.fahim.githubcommitlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fahim.githubcommitlist.databinding.CommitAdapterItemBinding
import com.fahim.githubcommitlist.model.Item

class CommitPagerAdapter(private var context: Context) :
    PagingDataAdapter<Item, CommitPagerAdapter.CommitViewHolder>(CommitComparator) {


    override fun onBindViewHolder(holder: CommitViewHolder, position: Int) {
        val item = getItem(position)
        holder.view.tvMessage.text = item?.commit?.message
        holder.view.tvAuthorName.text = item?.author?.login
        holder.view.tvTimeDate.text = item?.commit?.author?.date
        Glide.with(context).load(item?.author?.avatar_url).into(holder.view.ivAuthor);

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
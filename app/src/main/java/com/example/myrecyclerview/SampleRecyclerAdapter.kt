package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.model.DataModel


class SampleRecyclerAdapter : ListAdapter<DataModel, RecyclerView.ViewHolder>(BaseDiffCallback()) {

    var onItemClickListener: ((item: DataModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.sameple_layout,
                parent, false
            )
        return SampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SampleViewHolder) {
            val data = getItem(position) as DataModel
            holder.bindData(data, onItemClickListener)
        }
    }

    class BaseDiffCallback : DiffUtil.ItemCallback<DataModel>() {
        override fun areItemsTheSame(
            oldItem: DataModel, newItem: DataModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: DataModel
            , newItem: DataModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
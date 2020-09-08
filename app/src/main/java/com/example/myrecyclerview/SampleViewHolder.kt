package com.example.myrecyclerview

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.model.DataModel
import kotlinx.android.synthetic.main.sameple_layout.view.*

class SampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun bindData(
        item: DataModel,
        listener: ((item: DataModel) -> Unit)?
    ) = with(itemView) {

        //set UI
        tv_line1.text = item.val1
        tv_line2.text = item.val2

        //listener
        itemView.setOnClickListener {
            listener?.invoke(item)
        }
    }
}
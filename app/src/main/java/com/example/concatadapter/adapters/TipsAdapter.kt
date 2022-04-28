package com.example.concatadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.data.Tip
import com.example.concatadapter.databinding.CardItemBinding

class TipsAdapter : ListAdapter<Tip, TipsAdapter.TipsViewHolder>(DIFF_CALLBACK) {

    var iUnderstoodClickListener: ((Int?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        return TipsViewHolder.create(parent, iUnderstoodClickListener)
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TipsViewHolder(
        private val itemBinding: CardItemBinding,
        private val iUnderstoodClickListener: ((Int?) -> Unit)?
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(tip: Tip) {
            itemBinding.run {
                tipDescription.text = tip.description
                iUnderstood.setOnClickListener { iUnderstoodClickListener?.invoke(
                    absoluteAdapterPosition
                ) }
            }
        }

        companion object {
            fun create(parent: ViewGroup, iUnderstoodClickListener: ((Int?) -> Unit)?): TipsViewHolder {
                val itemBinding =
                    CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

                return TipsViewHolder(itemBinding, iUnderstoodClickListener)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Tip>() {
            override fun areItemsTheSame(oldItem: Tip, newItem: Tip): Boolean {
                return oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: Tip, newItem: Tip): Boolean {
                return oldItem == newItem
            }
        }
    }
}
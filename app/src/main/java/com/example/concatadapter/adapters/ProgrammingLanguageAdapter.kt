package com.example.concatadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.data.ProgrammingLanguage
import com.example.concatadapter.databinding.MainCardItemBinding

class ProgrammingLanguageAdapter :
    ListAdapter<ProgrammingLanguage, ProgrammingLanguageAdapter.ProgrammingLanguageViewHolder>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgrammingLanguageViewHolder {
        return ProgrammingLanguageViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProgrammingLanguageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProgrammingLanguageViewHolder(
        private val itemBinding: MainCardItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(programmingLanguage: ProgrammingLanguage) {
            itemBinding.run {
                textTitle.text = programmingLanguage.name
                textSubtitle.text = programmingLanguage.paradigm
                imageLanguage.setImageResource(programmingLanguage.logo)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ProgrammingLanguageViewHolder {
                val itemBinding =
                    MainCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

                return ProgrammingLanguageViewHolder(itemBinding)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProgrammingLanguage>() {
            override fun areItemsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
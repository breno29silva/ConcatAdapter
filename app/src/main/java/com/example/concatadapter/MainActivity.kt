package com.example.concatadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import com.example.concatadapter.adapters.ProgrammingLanguageAdapter
import com.example.concatadapter.adapters.TipsAdapter
import com.example.concatadapter.data.programmingLanguage
import com.example.concatadapter.data.tips
import com.example.concatadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var programmingLanguageAdapter: ProgrammingLanguageAdapter
    private lateinit var tipsAdapter: TipsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        programmingLanguageAdapter = ProgrammingLanguageAdapter()
        tipsAdapter = TipsAdapter().apply {
            iUnderstoodClickListener = {
                it?.let { dismissTip(it) }
            }
        }
        binding.recyclerView.adapter = ConcatAdapter(tipsAdapter, programmingLanguageAdapter)

        programmingLanguageAdapter.submitList(programmingLanguage)
        tipsAdapter.submitList(tips)
    }

    private fun dismissTip(position: Int) {
        tipsAdapter.notifyItemRemoved(position)
    }
}
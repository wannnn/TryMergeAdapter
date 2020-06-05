package com.claire.trymergeadapter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.MergeAdapter
import com.claire.trymergeadapter.adapter.BufferoosAdapter
import com.claire.trymergeadapter.adapter.WhatsNewAdapter
import com.claire.trymergeadapter.model.getMobileBufferoos
import com.claire.trymergeadapter.model.getMobileWhatsNew
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), ClickListener {
    private val whatsNewAdapter: WhatsNewAdapter by lazy {
        WhatsNewAdapter(
            this
        )
    }
    private val bufferoosAdapter: BufferoosAdapter by lazy {
        BufferoosAdapter(
            this
        )
    }
    private lateinit var mergeAdapter: MergeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val config = MergeAdapter.Config.Builder()
                .setIsolateViewTypes(false)
                .build()

        mergeAdapter = MergeAdapter(config, whatsNewAdapter, bufferoosAdapter)
        feedRecyclerView.adapter = mergeAdapter
        fetchNewFeatureDataFromServer()
        fetchBufferoos()
    }

    private fun fetchBufferoos() {

        val listOfBufferoos = getMobileBufferoos().sortedBy { it.name }
        bufferoosAdapter.bufferoos = listOfBufferoos
        bufferoosAdapter.notifyItemRangeInserted(0, listOfBufferoos.size)
        feedRecyclerView.scrollToPosition(0)
    }

    private fun fetchNewFeatureDataFromServer() {

        /**
         * Faking a long running network call.
         * This is a contrived example. Ideally this would be in a repository class
         * */
        CoroutineScope(Dispatchers.Main).launch {
            delay(2_000L)
            val list = getMobileWhatsNew()
            whatsNewAdapter.whatsNew = list
            whatsNewAdapter.notifyItemRangeInserted(0, list.size)
            feedRecyclerView.scrollToPosition(0)
        }
    }


    override fun onClick(position: Int) {
        Toast.makeText(this, "click:$position", Toast.LENGTH_SHORT).show()
    }
}
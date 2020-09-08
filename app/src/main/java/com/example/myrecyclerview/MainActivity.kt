package com.example.myrecyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.model.DataModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var recyclerViewAdapter = SampleRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mockListData = makeDataList(20)
        setupRecyclerView()
        updateListData(mockListData)
    }

    private fun setupRecyclerView() {
        recyclerViewAdapter.apply {
            onItemClickListener = {
                showToast(it.val1)
                Log.d("xxx", "do something")
            }
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerViewAdapter
        }
    }

    private fun updateListData(list: List<DataModel>) {
        recyclerViewAdapter.submitList(list)
    }

    private fun showToast(text: String?) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun makeDataList(round: Int): List<DataModel> {
        val listData = mutableListOf<DataModel>()
        for (i in 0..round) {
            listData.add(
                DataModel(
                    val1 = "Title [$i]:" + UUID.randomUUID().toString().substring(0, 8),
                    val2 = "Detail: " + UUID.randomUUID().toString()
                )
            )
        }
        return listData
    }
}
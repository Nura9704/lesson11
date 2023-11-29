package kz.course.lesson11

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: AppCompatButton
    private lateinit var removeButton: AppCompatButton
    private lateinit var adapter: NamesAdapter
    private val allNumbers = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initAdapter()
        initNames()
        initListeners()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.namesRecyclerView)
        addButton = findViewById(R.id.addButton)
        removeButton = findViewById(R.id.removeButton)
    }

    private fun initListeners() {
        addButton.setOnClickListener {addNumber()}
        removeButton.setOnClickListener {removeNumber()}
    }

    private fun initAdapter() {
        adapter = NamesAdapter()
        recyclerView.adapter = adapter
    }

    private fun initNames() {
        val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        allNumbers.addAll(numbers)

        adapter.setNames(allNumbers)
        adapter.notifyDataSetChanged()
    }

    private fun addNumber() {
        allNumbers.add(allNumbers.size + 1)

        adapter.notifyDataSetChanged()
    }

    private fun removeNumber() {
        allNumbers.removeAt(allNumbers.size - 1)

        adapter.notifyDataSetChanged()
    }
}
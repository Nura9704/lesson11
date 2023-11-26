package kz.course.lesson11

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: AppCompatButton
    private lateinit var removeButton: AppCompatButton
    private lateinit var adapter: NamesAdapter
    private var allNames = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setLayout()
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
        addButton.setOnClickListener {addName()}
        removeButton.setOnClickListener {removeName()}
    }

    private fun setLayout() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun initAdapter() {
        adapter = NamesAdapter()
        recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initNames() {

        val names = mutableListOf("Nurasyl", "Ainura")
        names.add("Alibek")
        names.add("Orazaiym")
        names.add("Qairat")

        allNames.addAll(names)
        allNames.addAll(names)
        allNames.addAll(names)

        adapter.setNames(allNames)
        adapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addName() {
        allNames.add(allNames.size.toString())

        adapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun removeName() {
        if (allNames.contains("Orazaiym")) {
            allNames.remove("Orazaiym")
        }

        adapter.notifyDataSetChanged()
    }
}
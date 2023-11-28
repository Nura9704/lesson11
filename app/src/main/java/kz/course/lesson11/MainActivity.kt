package kz.course.lesson11

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.course.lesson11.model.BaseClass
import kz.course.lesson11.model.Date
import kz.course.lesson11.model.Name

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: AppCompatButton
    private lateinit var removeButton: AppCompatButton
    private lateinit var adapter: NamesAdapter
    private var generalList = mutableListOf<BaseClass>()
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
        generalList.add(Date("14.09.2023"))
        val names = mutableListOf(Name("Nurasyl"), Name("Ainura"))
        generalList.addAll(names)

        generalList.add(Date("27.09.2023"))
        generalList.add(Name("Orazaiym"))
        generalList.add(Name("Alibek"))
        generalList.add(Name("Qairat"))

        generalList.add(Date("25.10.2023"))
        generalList.add(Name("Harry"))
        generalList.add(Name("Bob"))
        generalList.add(Name("Vasya"))

        adapter.setList(generalList)
        adapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addName() {
        //generalList.add(generalList.size.toString())

        adapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun removeName() {
        /*if (allNames.contains("Orazaiym")) {
            allNames.remove("Orazaiym")
        }*/

        adapter.notifyDataSetChanged()
    }
}
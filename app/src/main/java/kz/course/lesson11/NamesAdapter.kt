package kz.course.lesson11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NamesAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var names: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.name_item, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val name = names[position]
        (holder as NameViewHolder).onBind(name)
    }

    class NameViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        lateinit var nameTextView: TextView
        fun onBind(name: String) {
            nameTextView = view.findViewById(R.id.nameTextView)
            nameTextView.text = name
        }
    }

    fun setNames(names: List<String>) {
        this.names = names
    }
}
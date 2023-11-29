package kz.course.lesson11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NamesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var numbers: List<Int> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.name_item, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val number = numbers[position]
        (holder as NameViewHolder).onBind(number)
    }

    class NameViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        lateinit var nameTextView: TextView
        fun onBind(number: Int) {
            nameTextView = view.findViewById(R.id.nameTextView)
            nameTextView.text = number.toString()
        }
    }

    fun setNames(numbers: MutableList<Int>) {
        this.numbers = numbers
    }
}
package kz.course.lesson11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.course.lesson11.model.BaseClass
import kz.course.lesson11.model.Date
import kz.course.lesson11.model.Name

class NamesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var localList: List<BaseClass> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            TYPE_NAME -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.name_item, parent, false)
                return NameViewHolder(view)
            }
            TYPE_DATE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_date, parent, false)
                return NameViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.name_item, parent, false)
                return NameViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return localList.size
    }

    override fun getItemViewType(position: Int): Int {
        if (localList[position] is Name) {
            return TYPE_NAME
        } else if (localList[position] is Date) {
            return TYPE_DATE
        }
        return TYPE_NAME
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NameViewHolder) {
            val data = localList[position] as Name // java.lang.ClassCastException:
            // kz.course.lesson11.model.Date cannot be cast to kz.course.lesson11.model.Name
            holder.onBind(data.name)
        } else if (holder is DateViewHolder) {
            val data = localList[position] as Date
            holder.onBind(data)
        }
    }

    class NameViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        lateinit var nameTextView: TextView
        fun onBind(name: String) {
            nameTextView = view.findViewById(R.id.nameTextView)
            nameTextView.text = name
        }
    }

    class DateViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        lateinit var dateTextView: TextView
        fun onBind(date: Date) {
            dateTextView = view.findViewById(R.id.dateTextView)
            dateTextView.text = date.date
        }
    }

    fun setList(localList: List<BaseClass>) {
        this.localList = localList
    }

    companion object{
        private const val TYPE_NAME = 0
        private const val TYPE_DATE = 1
    }
}
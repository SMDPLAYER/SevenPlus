package uz.smd.sevenplusdictionary.ui.tasks.adapter


import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mysoftpanda.android.onlinelessonxiihomework.utils.extensions.inflate

import kotlinx.android.synthetic.main.item_words.view.*

import uz.smd.sevenplusdictionary.R
import uz.smd.sevenplusdictionary.di.service.room.entity.Word

import uz.smd.sevenplusdictionary.utils.bindItem



class DictionaryAdapter() : RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {
    var listener: ((Word) -> Unit)? = null
    private var tasksDay: MutableList<Word> = mutableListOf()
    fun setListenerGetPos(block: (Word) -> Unit){
        listener = block
    }

    fun setTasksDay(tasksDay: List<Word>) {
        this.tasksDay.clear()
        this.tasksDay.addAll(tasksDay)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_words))

    override fun getItemCount() = tasksDay.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =holder.bind()
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = itemView.nameText

//        init {
//            itemView.apply {
//                name.setOnClickListener{
//                    listener?.invoke(d)
//                }
//            }
//        }

        fun bind() = bindItem {

             val d = tasksDay[adapterPosition]
            name.setOnClickListener{
                listener?.invoke(d)
            }
            name.text = d.name ?: "Nomalum"


        }

    }




}
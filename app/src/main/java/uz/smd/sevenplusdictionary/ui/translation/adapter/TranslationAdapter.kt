package uz.smd.sevenplusdictionary.ui.translation.adapter


import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mysoftpanda.android.onlinelessonxiihomework.utils.extensions.inflate

import kotlinx.android.synthetic.main.item_words.view.*

import uz.smd.sevenplusdictionary.R
import uz.smd.sevenplusdictionary.di.service.room.entity.TranslatedWords
import uz.smd.sevenplusdictionary.di.service.room.entity.Word
import uz.smd.sevenplusdictionary.utils.bindItem
import java.lang.Exception


class TranslationAdapter() : RecyclerView.Adapter<TranslationAdapter.ViewHolder>() {

    private var tasksDay: MutableList<Word> = mutableListOf()
    var listener: ((Word) -> Unit)? = null
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



        fun bind() = bindItem {
            name.setOnClickListener {

            }

            try {
                val d = tasksDay[adapterPosition+1]
                name.setOnClickListener{
                    listener?.invoke(d)
                }
                var s=d.name ?: "Nomalum"
                name.text = s.capitalize()
            }catch (e:Exception){
                e.printStackTrace()
                itemView.visibility=View.GONE
            }



        }

    }




}
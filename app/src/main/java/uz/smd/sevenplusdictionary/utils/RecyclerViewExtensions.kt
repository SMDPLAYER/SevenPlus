package uz.smd.sevenplusdictionary.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.RecyclerView
import uz.smd.sevenplusdictionary.R


fun RecyclerView.ViewHolder.bindItem(block: View.() -> Unit) = block(itemView)

 fun runLayoutAnimation(recyclerView: RecyclerView) {
    val context: Context = recyclerView.context
    val controller: LayoutAnimationController =
        AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
    recyclerView.layoutAnimation = controller
    recyclerView.adapter!!.notifyDataSetChanged()
    recyclerView.scheduleLayoutAnimation()
}
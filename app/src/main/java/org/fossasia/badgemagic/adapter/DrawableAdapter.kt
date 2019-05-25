package org.fossasia.badgemagic.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.fossasia.badgemagic.R
import org.fossasia.badgemagic.data.DrawableInfo

class DrawableAdapter : RecyclerView.Adapter<DrawableItemHolder>() {
    var onDrawableSelected: OnDrawableSelected? = null
    private val drawableList = mutableListOf<DrawableInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawableItemHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return DrawableItemHolder(v)
    }

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: DrawableItemHolder, position: Int) {
        holder.apply {
            bind(drawableList[position])
            listener = onDrawableSelected
        }
    }

    fun addAll(newDrawableList: List<DrawableInfo>) {
        if (drawableList.isNotEmpty()) drawableList.clear()
        drawableList.addAll(newDrawableList)
        notifyDataSetChanged()
    }

    override fun getItemCount() = drawableList.size
}

interface OnDrawableSelected {
    fun onSelected(selectedItem: DrawableInfo)
}
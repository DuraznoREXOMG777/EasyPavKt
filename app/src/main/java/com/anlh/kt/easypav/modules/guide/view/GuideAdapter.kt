package com.anlh.kt.easypav.modules.guide.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.data.model.Guide
import com.anlh.kt.easypav.util.AppConstants
import com.anlh.kt.easypav.util.inflate
import java.lang.IllegalArgumentException

class GuideAdapter(private val items: List<Guide>) :
    RecyclerView.Adapter<GuideAdapter.GuideContentVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideContentVH {
        return GuideContentVH(parent.inflate(viewType, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GuideContentVH, position: Int) {
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    class GuideContentVH(itemView: View) : RecyclerView.ViewHolder(itemView)

}


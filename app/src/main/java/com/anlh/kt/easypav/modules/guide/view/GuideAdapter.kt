package com.anlh.kt.easypav.modules.guide.view

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.anlh.kt.easypav.R
import com.anlh.kt.easypav.data.model.Guide
import com.anlh.kt.easypav.util.inflate
import com.squareup.picasso.Picasso

class GuideAdapter(private val items: List<Guide>) : RecyclerView.Adapter<GuideAdapter.GuideContentVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideContentVH {
        return GuideContentVH(
            parent.inflate(
                R.layout.item_guide,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GuideContentVH, position: Int) {
        Picasso.get().load(items[position].imageUrl).into(holder.imageGuide)
        holder.textContent.text = items[position].text
    }


    class GuideContentVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            ButterKnife.bind(this, itemView)
        }

        @BindView(R.id.image_guide)
        lateinit var imageGuide: AppCompatImageView
        @BindView(R.id.text_content)
        lateinit var textContent: AppCompatTextView

    }

}


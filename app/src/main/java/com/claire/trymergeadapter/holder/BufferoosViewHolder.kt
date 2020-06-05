package com.claire.trymergeadapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.claire.trymergeadapter.ClickListener
import com.claire.trymergeadapter.R
import com.claire.trymergeadapter.model.Bufferoo
import com.claire.trymergeadapter.utils.dpToPx
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_bufferoo.*

class BufferoosViewHolder(override val containerView: View,
                          private val listener: ClickListener
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(bufferoo: Bufferoo) {
        itemBg.setOnClickListener {
            listener.onClick(bindingAdapterPosition)
        }
        bufferooName.text = bufferoo.name
        bufferooRole.text = bufferoo.role
        image.load(bufferoo.image) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_foreground)
            val dp = dpToPx(containerView.context, 5)
            transformations(RoundedCornersTransformation(dp.toFloat()))
        }
    }
}
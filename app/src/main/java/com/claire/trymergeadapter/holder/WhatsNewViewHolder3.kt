package com.claire.trymergeadapter.holder

import android.view.View
import com.claire.trymergeadapter.BaseViewHolder
import com.claire.trymergeadapter.ClickListener
import com.claire.trymergeadapter.wrapper.WhatsNewWrapper
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_whats_new_3.*

class WhatsNewViewHolder3(override val containerView: View,
                          private val listener: ClickListener
) : BaseViewHolder<WhatsNewWrapper>(containerView), LayoutContainer {

    override fun bindView(position: Int, t: WhatsNewWrapper) {
        whatsNew.text = t.description
        dismiss.setOnClickListener {
            listener.onClick(absoluteAdapterPosition)
        }
    }
}
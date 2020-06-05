package com.claire.trymergeadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claire.trymergeadapter.BaseViewHolder
import com.claire.trymergeadapter.ClickListener
import com.claire.trymergeadapter.R
import com.claire.trymergeadapter.holder.WhatsNewViewHolder1
import com.claire.trymergeadapter.holder.WhatsNewViewHolder2
import com.claire.trymergeadapter.holder.WhatsNewViewHolder3
import com.claire.trymergeadapter.wrapper.IWhatsNew
import com.claire.trymergeadapter.wrapper.WhatsNewWrapper

class WhatsNewAdapter(private val listener: ClickListener) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    var whatsNew: List<WhatsNewWrapper> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when(viewType) {
            IWhatsNew.ONE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_whats_new_1, parent, false)
                WhatsNewViewHolder1(view, listener)
            }
            IWhatsNew.TWO -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_whats_new_2, parent, false)
                WhatsNewViewHolder2(view, listener)
            }
            IWhatsNew.THREE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_whats_new_3, parent, false)
                WhatsNewViewHolder3(view, listener)
            }
            else -> object : BaseViewHolder<IWhatsNew>(View(parent.context)) {
                override fun bindView(position: Int, t: IWhatsNew) {}
            }
        }
    }

    override fun getItemCount() = whatsNew.size

    override fun getItemViewType(position: Int): Int = whatsNew[position].itemViewType

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is WhatsNewViewHolder1 -> holder.bindView(position, whatsNew[position])
            is WhatsNewViewHolder2 -> holder.bindView(position, whatsNew[position])
            is WhatsNewViewHolder3 -> holder.bindView(position, whatsNew[position])
        }
    }
}
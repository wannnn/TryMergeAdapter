package com.claire.trymergeadapter.wrapper

import com.claire.trymergeadapter.model.WhatsNew

class WhatsNewWrapper(whatsNew: WhatsNew, override val itemViewType: Int): IWhatsNew {

    val description = whatsNew.description
}
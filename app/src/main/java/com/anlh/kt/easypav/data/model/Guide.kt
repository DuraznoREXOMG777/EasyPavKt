package com.anlh.kt.easypav.data.model

import com.anlh.kt.easypav.util.AppConstants
import com.highflyers.commonresources.AppBaseItem


data class Guide(val text: String, val imageUrl: String, override var type: Int): AppBaseItem

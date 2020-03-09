package com.anlh.kt.easypav.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun Context.showToast(text: CharSequence) =
    Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()

fun Context.showToast(@StringRes res: Int) =
    Toast.makeText(applicationContext, res, Toast.LENGTH_SHORT).show()
package com.anlh.kt.easypav.core

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class AppPreferencesHelper(context: Context): IPreferenceHelper {

    private val PREF_NAME = "EASY_PAV_PREF"
    private val PREF_FIRST_OPEN = "FIRST_OPEN"
    private val PREF_USER = "EASY_PAV_USER"

    private var preferencesHelper: SharedPreferences

    init {
         preferencesHelper = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun setFirstOpen(open:Boolean) = preferencesHelper.edit {
            putBoolean(PREF_FIRST_OPEN, open)
        }

    override fun getFirstOpen(): Boolean = preferencesHelper.getBoolean(PREF_FIRST_OPEN, true)

    override fun setUser(user: String) = preferencesHelper.edit {
            putString(PREF_USER, user)
        }

    override fun getUser(): String? = preferencesHelper.getString(PREF_USER, null)
}
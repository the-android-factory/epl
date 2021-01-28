package com.androidfactory.epl

import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseMainActivityFragment(layoutId: Int): Fragment(layoutId) {

    val mainActivity: MainActivity by lazy { activity as MainActivity }

    fun setToolbarTitle(title: String) {
        mainActivity.supportActionBar?.title = title
    }

    fun toast(text: String) {
        Toast.makeText(mainActivity, text, Toast.LENGTH_SHORT).show()
    }
}
package com.example.feature_purple.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.feature_purple.R

class CustomComponentPurple @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {


    init {
        LayoutInflater.from(context)
            .inflate(R.layout.custom_component_purple, this, true)
    }
}
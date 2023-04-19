package com.example.skillcinema.presentation.firstpartpresentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.LoadState
import com.example.skillcinema.databinding.LayoutLoadingBinding

class CustomLoadingLayout
@JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    val binding = LayoutLoadingBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
    }
}
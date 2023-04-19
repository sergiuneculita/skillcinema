package com.example.skillcinema.presentation.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.skillcinema.R
import com.example.skillcinema.databinding.CustomPhotoFilmForFilmFragmentBinding

class CustomPhotoFilmForFilmFragment @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    val binding = CustomPhotoFilmForFilmFragmentBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)


    }


}

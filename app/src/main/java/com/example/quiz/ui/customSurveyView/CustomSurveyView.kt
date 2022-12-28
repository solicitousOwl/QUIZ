package com.example.quiz.ui.customSurveyView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.quiz.R
import com.example.quiz.databinding.CustomSurveyViewBinding

class   CustomSurveyView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    val binding: CustomSurveyViewBinding
    init {
        val root = inflate(context, R.layout.custom_survey_view, this)
        binding = CustomSurveyViewBinding.bind(root)
    }
}
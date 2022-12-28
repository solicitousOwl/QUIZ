package com.example.quiz.ui.result

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quiz.R
import com.example.quiz.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultText = arguments?.getString(QUIZ_ANSWERS_KEY)
        binding.textResult.text = resultText

        binding.restartButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_navigation_dashboard)
        }

        ObjectAnimator.ofFloat(binding.textResult, View.ROTATION_X, 0f, 360f).apply {
            duration = 1000
            start()
        }

        ObjectAnimator.ofFloat(binding.restartButton, View.ROTATION_X, 360f).apply {
            duration = 1800
            start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val QUIZ_ANSWERS_KEY = "QUIZ_ANSWERS"
    }
}
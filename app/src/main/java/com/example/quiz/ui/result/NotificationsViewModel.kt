package com.example.quiz.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "You will see the result here. Please, go back and do the survey"
    }
    val text: LiveData<String> = _text
}
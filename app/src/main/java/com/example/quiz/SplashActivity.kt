package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quiz.databinding.SplashActivityBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: SplashActivityBinding
    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd.MM.yy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java),
            )
        }

        binding.datePickerButton.setOnClickListener {
            val dateDialog = MaterialDatePicker.Builder.datePicker()
                .setTitleText(resources.getString(R.string.date_dialog_title))
                .build()
            dateDialog.addOnPositiveButtonClickListener { timeInMillis ->
                calendar.timeInMillis = timeInMillis
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val month = calendar.get(Calendar.MONTH)
                val year = calendar.get(Calendar.YEAR)

                Snackbar.make(binding.datePickerButton, dateFormat.format(calendar.time), Snackbar.LENGTH_SHORT).show()
            }

            dateDialog.show(supportFragmentManager, "DatePicker")
        }

        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.appearing_anim)
        binding.datePickerButton.startAnimation(fadeInAnimation)
        binding.startButton.startAnimation(fadeInAnimation)
        binding.welcomeTextView.startAnimation(fadeInAnimation)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("The confirmation")
            setMessage("Are you sure you want to exit the app?")

            setPositiveButton("Yes") { _, _ ->
                super.onBackPressed()
                finish()
            }

            setNegativeButton("No") { _, _ ->
                // if user press no, then return the activity
                Toast.makeText(
                    this@SplashActivity, "Thank you",
                    Toast.LENGTH_LONG
                ).show()
            }
            setCancelable(true)
        }.create().show()
    }
}
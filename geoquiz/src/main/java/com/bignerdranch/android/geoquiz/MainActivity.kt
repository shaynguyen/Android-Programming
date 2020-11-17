package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener { view: View ->
            showTopToast(R.string.correct_toast)
        }

        falseButton.setOnClickListener { view: View ->
            showTopToast(R.string.incorrect_toast)
        }

    }

    private fun showTopToast(textResId: Int) {
        val toast = Toast.makeText(this, textResId, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }
}
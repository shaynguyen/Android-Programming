package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreated")

        questionTextView = findViewById(R.id.question_text_view)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
            updateAnswerButtonState()
            displayGradeOnComplete()
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
            updateAnswerButtonState()
            displayGradeOnComplete()
        }

        nextButton.setOnClickListener { view: View ->
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
            updateAnswerButtonState()
        }

        updateQuestion()
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    private fun updateQuestion() {
        val questionResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == questionBank[currentIndex].answer) {
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
        }

        recordAnswer(userAnswer)
    }

    private fun recordAnswer(userAnswer: Boolean) {
        questionBank[currentIndex].userAnswer = userAnswer
    }


    private fun updateAnswerButtonState() {
        trueButton.isEnabled = questionBank[currentIndex].userAnswer == null
        falseButton.isEnabled = questionBank[currentIndex].userAnswer == null
    }

    private fun displayGradeOnComplete() {
        if (isQuizComplete()) {
            displayGradeToast()
            nextButton.isEnabled = false
        }
    }

    private fun isQuizComplete(): Boolean {
        return questionBank.all { question -> question.userAnswer != null }
    }

    private fun displayGradeToast() {
        val score = questionBank.filter { question ->
            question.answer == question.userAnswer
        }.count()

        val result = "Score: $score / ${questionBank.size}"
        questionTextView.text = result
    }
}
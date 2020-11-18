package com.bignerdranch.android.geoquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val KEY_CHEATED = "cheated"
private const val EXTRA_ANSWER_IS_TRUE =
    "com.bignerdranch.android.geoquiz.answer_is_true"
const val EXTRA_ANSWER_SHOWN =
    "com.bignerdranch.android.geoquiz.answer_is_shown"

class CheatActivity : AppCompatActivity() {
    private lateinit var answerTextView: TextView
    private lateinit var showAnswerButton: Button

    private var answerIsTrue = false
    private var hasCheated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        hasCheated = savedInstanceState?.getBoolean(KEY_CHEATED, false) ?: false
        if (hasCheated) {
            setAnswerShownResult(true)
        }

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        answerTextView = findViewById(R.id.answer_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)

        showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.correct_toast
                else -> R.string.incorrect_toast
            }

            hasCheated = true
            answerTextView.setText(answerText)
            setAnswerShownResult(true)
            setAnswerShownResult(hasCheated)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_CHEATED, hasCheated)
    }

    override fun onDestroy() {
        super.onDestroy()
        setAnswerShownResult(hasCheated)
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java)
                .apply {
                    putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
                }
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }
}
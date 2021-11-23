package com.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val playerName = intent.getStringExtra(Constants.USER_NAME)
        congratulation.text = "Congratulations $playerName!"
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        score.text = "Your Score is $correctAnswers out of $totalQuestions!"

        finishButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}
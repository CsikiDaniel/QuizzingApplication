package com.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        getPlayerName()

         mQuestionsList = Constants.getQuestions()

        setQuestion()

        optionOne.setOnClickListener ( this )
        optionTwo.setOnClickListener ( this )
        optionThree.setOnClickListener ( this )
        optionFour.setOnClickListener ( this )
        submitButton.setOnClickListener ( this )

    }

    private fun setQuestion() {

         mCurrentPosition = 1
        val question: Question? = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionView()

        progressBar.progress = mCurrentPosition
        progressNumber.text = "$mCurrentPosition" + "/" + progressBar.max

        questionText.text = question!!.question
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour
    }


    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0,optionOne)
        options.add(1,optionTwo)
        options.add(2,optionThree)
        options.add(3,optionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.deafult_option_border_bg)
        }
    }


    fun getPlayerName() {
        val message = intent.getStringExtra(USERNAME_EXTRA)
        Toast.makeText(this, "Hello " + message.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onClick(p0: View?) {

        when(p0?.id) {
            R.id.optionOne -> { selectedOptionView(optionOne,1)}
            R.id.optionTwo -> { selectedOptionView(optionTwo,2)}
            R.id.optionThree -> { selectedOptionView(optionThree,3)}
            R.id.optionFour -> { selectedOptionView(optionFour,4)}
            R.id.submitButton -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> { optionOne.background = ContextCompat.getDrawable(this,drawableView)}
            2 -> { optionTwo.background = ContextCompat.getDrawable(this,drawableView)}
            3 -> { optionThree.background = ContextCompat.getDrawable(this,drawableView)}
            4 -> { optionFour.background = ContextCompat.getDrawable(this,drawableView)}
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {

        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#7A8089"))
        tv.setTypeface(tv.typeface,Typeface.BOLD_ITALIC)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }
}
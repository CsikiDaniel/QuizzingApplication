package com.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val question1 = Question(1,
            "What is the difference between val and var?",
            "Val is immutable, var is mutable.",
            "No difference.",
            "Var is immutable, val is mutable.",
            "Var is read-only.",1)

        questionList.add(question1)

        return questionList

    }
}
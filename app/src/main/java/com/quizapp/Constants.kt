package com.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val question1 = Question(1,
            "What is the difference between val and var?",
            "Val is immutable, var is mutable.",
            "No difference.",
            "Var is immutable, val is mutable.",
            "Var is read-only.",1)

        questionList.add(question1)

        val question2 = Question(1,
            "What does the joinToString function do??",
            "Merges the items in the list.",
            "Returns the length of the list.",
            "It compares two strings.",
            "It tells you how many items are in the list.",1)

        questionList.add(question2)

        val question3 = Question(1,
            "What does the map do?",
            "It creates a class.",
            "We do not use it for lists.",
            "Performs a transformation on the input list.",
            "Interface definition.",3)

        questionList.add(question3)

        return questionList

    }
}
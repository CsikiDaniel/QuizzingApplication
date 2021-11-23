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

        val question4 = Question(1,
            "What is the open keyword??",
            "It can be derived from it.",
            "You can't derail it.",
            "Indicates an interface implementation.",
            "Indicates an abstract class.",1)

        questionList.add(question4)

        val question5 = Question(1,
            "What is the name of the construct block in kotlin?",
            "override",
            "super",
            "init",
            "class",3)

        questionList.add(question5)

        val question6 = Question(1,
            "What does lateinite mean?",
            "The type of variable val.",
            "The expression only gets values later.",
            "A variable var type.",
            "Define a new type.",2)

        questionList.add(question6)

        val question7 = Question(1,
            "What is the difference between val and var?",
            "Val is immutable, var is mutable.",
            "No difference.",
            "Var is immutable, val is mutable.",
            "Var is read-only.",1)

        questionList.add(question7)

        val question8 = Question(1,
            "What is the difference between val and var?",
            "Val is immutable, var is mutable.",
            "No difference.",
            "Var is immutable, val is mutable.",
            "Var is read-only.",1)

        questionList.add(question8)

        val question9 = Question(1,
            "What is the difference between val and var?",
            "Val is immutable, var is mutable.",
            "No difference.",
            "Var is immutable, val is mutable.",
            "Var is read-only.",1)

        questionList.add(question9)

        val question10 = Question(1,
            "What is the difference between val and var?",
            "Val is immutable, var is mutable.",
            "No difference.",
            "Var is immutable, val is mutable.",
            "Var is read-only.",1)

        questionList.add(question10)

        return questionList

    }
}
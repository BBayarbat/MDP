package com.demo.android.bayarbat.data

import com.demo.android.bayarbat.data.entity.Answer
import com.demo.android.bayarbat.data.entity.Question

class QuestionAndAnswerListProvider {

    var questionList = initQuestionList()
    var answerList = initAnswersList()

    private fun initQuestionList(): MutableList<Question> {
        val questions = mutableListOf<Question>()
        questions.add(
            Question(1, "1. Which the right code to declare nullable variable in Kotlin?")
        )
        questions.add(
            Question(2, "2. Which keyword used to create a mutable variable?")
        )
        questions.add(
            Question(3, "3.  Kotlin is developed by?")
        )
        questions.add(
            Question(4, "4. Which of following is used to handle null exceptions in Kotlin?")
        )
        questions.add(
            Question(5, "5. Which file extension is used to save Kotlin files?")
        )
        questions.add(
            Question(6, "6. All classes in Kotlin classes are by default?")
        )
        questions.add(
            Question(7, "7. What is correct way to create an arraylist in Kotlin?")
        )
        questions.add(
            Question(8, "8. What is an immutable variable?")
        )
        questions.add(
            Question(9, "9. Which of following targets currently no supported by Kotlin?")
        )
        questions.add(
            Question(10, "10. How to make a multi  lined comment in Kotlin?")
        )
        questions.add(
            Question(11, "11. Which of the followings constructors are available in Kotlin?")
        )
        questions.add(
            Question(12, "12. There are two types of constructors in Kotlin which are?")
        )
        questions.add(
            Question(13, "13. Which of these features are available in Kotlin but not in the Java language?")
        )
        questions.add(
            Question(14, "14. val short for Value, a constant which cannot be changed once assigned?")
        )
        questions.add(
            Question(15, "15. What defines a sealed class in Kotlin?")
        )

        return questions
    }

    private fun initAnswersList(): MutableList<Answer> {
        val answers = mutableListOf<Answer>()
        answers.add(
            Answer(
                1, 1, false, "val text: String = null"
            )
        )
        answers.add(
            Answer(
                2, 1, false, "val text: nullable = null"
            )
        )
        answers.add(
            Answer(
                3, 1, true, "val text: String? = null"
            )
        )

        answers.add(
            Answer(
                21, 2, true, "A. var"
            )
        )
        answers.add(
            Answer(
                22, 2, false, "B. val"
            )
        )
        answers.add(
            Answer(
                23, 2, false, "C. mutable"
            )
        )

        answers.add(
            Answer(
                31, 3, false, "A. Google"
            )
        )
        answers.add(
            Answer(
                32, 3, true, "B. JetBrains"
            )
        )
        answers.add(
            Answer(
                33, 3, false, "C. Adobe"
            )
        )

        answers.add(
            Answer(
                41, 4, false, "A. Range"
            )
        )
        answers.add(
            Answer(
                42, 4, true, "B. Elvis Operator"
            )
        )
        answers.add(
            Answer(
                43, 4, false, "C. Lambda function"
            )
        )

        answers.add(
            Answer(
                51, 5, false, "A. *.kot"
            )
        )
        answers.add(
            Answer(
                52, 5, true, "B. *.kt or .kts"
            )
        )
        answers.add(
            Answer(
                53, 5, false, "C. *.android"
            )
        )

        answers.add(
            Answer(
                61, 6, true, "A. public"
            )
        )
        answers.add(
            Answer(
                62, 6, false, "B. final"
            )
        )
        answers.add(
            Answer(
                63, 6, false, "C. sealed"
            )
        )

        answers.add(
            Answer(
                71, 7, false, "A. val set = hashSetOf(1, 2, 3)"
            )
        )
        answers.add(
            Answer(
                72, 7, true, "B. val list = arrayListOf(1, 2, 3)"
            )
        )
        answers.add(
            Answer(
                73, 7, false, "C. enum class Color {RED, GREEN, BLUE}"
            )
        )

        answers.add(
            Answer(
                81, 8, true, "A. A variable that cannot change, read-only"
            )
        )
        answers.add(
            Answer(
                82, 8, false, "B. A variable that can be changed"
            )
        )
        answers.add(
            Answer(
                83, 8, false, "C. A variable used for string interpolation"
            )
        )

        answers.add(
            Answer(
                91, 9, false, "A. LLVM"
            )
        )
        answers.add(
            Answer(
                92, 9, true, "B. .NET CLR"
            )
        )
        answers.add(
            Answer(
                93, 9, false, "C. Javascript"
            )
        )

        answers.add(
            Answer(
                101, 10, false, "A. //"
            )
        )
        answers.add(
            Answer(
                102, 10, true, "B. /* */"
            )
        )
        answers.add(
            Answer(
                103, 10, false, "C. ##"
            )
        )

        answers.add(
            Answer(
                111, 11, false, "A. Primary constructor"
            )
        )
        answers.add(
            Answer(
                112, 11, false, "B. Secondary constructor"
            )
        )
        answers.add(
            Answer(
                113, 11, true, "C. Both A & B"
            )
        )

        answers.add(
            Answer(
                121, 12, true, "A. Primary & Secondary constructor"
            )
        )
        answers.add(
            Answer(
                122, 12, false, "B. Default & No-arg constructor"
            )
        )
        answers.add(
            Answer(
                123, 12, false, "C. Parameterized & constant Constructor"
            )
        )

        answers.add(
            Answer(
                131, 13, false, "A. Operator overloading"
            )
        )
        answers.add(
            Answer(
                132, 13, false, "B. Range expressions"
            )
        )
        answers.add(
            Answer(
                133, 13, true, "C. All of the above"
            )
        )

        answers.add(
            Answer(
                141, 14, false, "A. It can be changed but once only"
            )
        )
        answers.add(
            Answer(
                142, 14, false, "B. It can be changed"
            )
        )
        answers.add(
            Answer(
                143, 14, true, "C. val cannot be changed after its assigned"
            )
        )
        answers.add(
            Answer(
                151, 15, false, "A. Its another name for an abstract class"
            )
        )
        answers.add(
            Answer(
                152, 15, true, "B. It represents restricted class hierarchies"
            )
        )
        answers.add(
            Answer(
                153, 15, false, "C. It is used in every Kotlin program"
            )
        )

        return answers
    }

}
package com.example.kpsssnavsorular

data class Questions(val Question_One_Part: String, val Question_Two_Part: String, val Result: String, val AnswerA: String, val AnswerB: String, val AnswerC: String, val AnswerD: String, val AnswerE: String) {
}

data class Results(val TestId: Int, val QuestionNumber: Int, val TrueResultNumber: Int, val FalseResultNumber: Int, val EmptyResultNumber: Int, val Net: Double, val Time: String) {
}

var dataModel: ArrayList<DataModel>? = null
var countIndex: Int = 0
lateinit var questionList: MutableList<Questions>
var Answer: String = ""
val answerList: MutableList<String> = mutableListOf()
val trueList: MutableList<String> = mutableListOf()
val falseList: MutableList<String> = mutableListOf()
var netCount: Double = 0.0
var emptyCount: Int = 0
var indexFlag : Int = 0
var timerIsCheck : Boolean = false
var timerTextViewAccess : String = ""
package me

import java.lang.Exception

class realProb1 {
    fun Calculator(s: String): Any {

        // 1. 정규식
        val regex = """(\d+)(\+|\-|\*|\/)(\d+)""".toRegex()
        val matchResult = regex.find(s)

        try {
            val (first, op, second) = matchResult!!.destructured
            if (first.length + op.length + second.length != s.length) {
                throw Exception("공백을 제거해주세요")
            }

            // 2. 연산
            when (op.single().toInt()) {
                '+'.toInt() -> return first.toInt() + second.toInt()
                '-'.toInt() -> return first.toInt() - second.toInt()
                '*'.toInt() -> return first.toInt() * second.toInt()
                '/'.toInt() -> return first.toDouble() / second.toInt()
            }
        } catch (e: Exception) {
            return println(e.message)
        }
        return -1
    }
}


fun main(){
    val inputdata = readLine().toString()
    val cal = realProb1()
    println(cal.Calculator(inputdata))
}




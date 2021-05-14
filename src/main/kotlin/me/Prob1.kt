package me

import java.lang.Exception

//TODO (05.14.Fri)
//1. 22줄 : !! 수정
//2. 각 케이스에 맞는 exception 처리 및 작



동

class Prob1 { //이름명 + 파일 까지 다 바꾸는 방법 : mod+shift+F6
                // 클래스명 : 대문자시작, 함수명 : 소문자시작
    fun calculator(data: String): Number? { //Any로 두면 어떤 함수인지 감이 안잡히니까 더 세밀하게 잡기

        // 1. 정규식
        val regex = """(\d+)(\+|\-|\*|\/)(\d+)""".toRegex()
        val matchResult = regex.find(data)

        try {
            val (first, op, second) = matchResult!!.destructured

            // 2. 연산
            when (op) {  // Char이 ==안먹으면, String으로 바꿔도
                "+" -> return first.toInt() + second.toInt()
                "-" -> return first.toInt() - second.toInt()
                "*" -> return first.toInt() * second.toInt()
                "/" -> return first.toDouble() / second.toDouble()
            }
        } catch (e: Exception) {
            println(e.message)
            return null
        }
        return -1
    }
}


fun main(){
    val inputdata = readLine().toString().replace(" ", "")
    val cal = Prob1()
    println(cal.calculator(inputdata))
}




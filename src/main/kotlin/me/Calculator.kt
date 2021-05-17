package me

import java.lang.Exception
import java.math.BigDecimal


class Calculator {
    fun calculatingString(data: String): Number? {

        val regex = """(\d+)(\+*|\-*|\**|\/*)(\d+)""".toRegex()
        val matchResult = regex.find(data)

        try {
            val (first, op, second) = matchResult!!.destructured

            return when (op) {
                "+" -> first.toBigDecimal() + second.toBigDecimal()
                "-" -> first.toBigDecimal() - second.toBigDecimal()
                "*" -> first.toBigDecimal() * second.toBigDecimal()
                "/" -> first.toBigDecimal().divide(second.toBigDecimal(), 4, BigDecimal.ROUND_DOWN)
                else -> {
                    println("+, -, *, / 연산자를 입력해주세요.")
                    null
                }
            }
        } catch(e: NullPointerException){
            return null
        }
        catch( e: ArithmeticException) {
            println("${Double.MIN_VALUE} 보다 크게, ${Double.MAX_VALUE} 보다 작은 값을 넣어주세요")
            return null
        } catch (e: Exception) {
            println("식을 바르게 입력해 주세요")
            return null
        }
    }
}

fun main(args: Array<String>){
    val inputData = readLine().toString().replace(" ", "")
    val cal = Calculator()
    println(cal.calculatingString(inputData))

}

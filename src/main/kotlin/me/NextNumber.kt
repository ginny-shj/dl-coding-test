package me

class NextNumber {
    fun findNext(data: String): String {
        try{
            if ('0' in data) return "0을 제외하고 입력해 주세요"
            if (data.toInt() !in 1..1_000_000) return "1과 1,000,000 사이의 값을 입력해 주세요"

            var next = data.toInt() + 1

            while ('0' in next.toString()){
                next += 1
            }
            return next.toString()
        } catch(e: NumberFormatException){
            return "1과 1,000,000 사이의 정수를 입력해 주세요"
        }
    }
}


fun main(args: Array<String>){
    val inputData = readLine().toString().replace(" ", "")
    val nextNumber = NextNumber().findNext(inputData)
    println(nextNumber)
}

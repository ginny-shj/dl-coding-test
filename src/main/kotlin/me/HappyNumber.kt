package me


class HappyNumber {
    fun determineHappy(data: String) : String {
        try {
            var number = data.toInt()
            if (number !in 1..1_000_000_000) return "1과 1,000,000,000 사이의 수를 입력하세요."

            var sum = 0
            var set = mutableSetOf<Int>()

            while (sum != 1) {
                sum = 0
                while (number != 0) {
                    sum += (number % 10) * (number % 10)
                    number /= 10
                }
                if (set.contains(sum)) {
                    return "UNHAPPY"
                }
                set.add(sum)
                number = sum
            }
            return "HAPPY"

        } catch(e: NumberFormatException){
            return "정수를 입력하세요"
        }
    }
}


fun main(args: Array<String>){
    val inputData = readLine().toString().replace(" ", "")
    val numberAlgorithm = HappyNumber()
    println(numberAlgorithm.determineHappy(inputData))

}
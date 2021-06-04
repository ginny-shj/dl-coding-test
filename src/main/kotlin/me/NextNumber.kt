package me


class NextNumber(val currentNumber: String){

    fun findNext(): String{
        val nextNumber = (currentNumber.toInt() + 1).toString()
        val charList = nextNumber.toCharArray()

        for (i in charList.indices) {
            if (charList[i] == '0') charList[i] = '1'
        }
        return String(charList)
    }

    fun validateInput(){
        if ('0' in currentNumber) {
            throw InputNotValidException("0을 제외하고 입력해 주세요")
        }
        if (currentNumber.toInt() !in 1..1_000_000){
            throw InputNotValidException("1과 1,000,000 사이의 값을 입력해 주세요")
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputData = args[0].replace(" ", "")
            try {
                val numberSet = NextNumber(inputData)
                numberSet.validateInput()
            } catch(e: InputNotValidException){
                println(e.message)
            } catch(e: Exception){
                println(e.message)
            }
        }
    }
}

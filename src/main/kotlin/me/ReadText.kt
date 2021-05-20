package me

import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader

class ReadText {

    fun readFile(data: String) : String? {
        try {
            var resultString = ""
            if (File(data).length() > 1000 ) {
                return "텍스트 파일 용량이 초과되었습니다"
            }

            val file = FileReader(data)
            var list = file.readText().split(" ", "\n").sortedWith(Comparator<String> { a, b ->
                when {
                    a > b -> 1
                    a < b -> -1
                    else -> 0
                }
            }).sortedWith(compareBy { it.length })

            for (component in list) {
                if (component == "") {
                    continue
                }
                resultString = resultString.plus(component)
                if (component != list[list.size - 1]) {
                    resultString = resultString.plus("\n")
                }
            }
            return resultString
        } catch(e: FileNotFoundException){
            return "영문 파일을 찾을 수 없거나, 용량이 초과되었습니다."
        }
    }
}

fun main(args: Array<String>){
    val inputData = readLine().toString().replace(" ", "")
    val newFile = ReadText().readFile(inputData)
    println(newFile)
}
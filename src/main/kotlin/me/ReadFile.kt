package me

import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader


class ReadFile(private val filePath: String){

    fun readFile(): List<String> {
        val file = FileReader(filePath)
        return file.readText()
                    .split(" ", "\n")
                    .distinct()
                    .filter{ it.length != 0}
    }

    fun validCapacity(){
        if (File(filePath).length() > 1000) throw InvalidCapacityException("1메가 이하의 파일만 가능합니다.")
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            val inputData = args[0].replace(" ", "")
            try {
                val readText: ReadFile = ReadFile(inputData)
                readText.validCapacity()

                val sortText: SortList = SortList(readText.readFile())
                sortText.validContent()

                println(sortText.sorting())
            } catch(e: FileNotFoundException){ println("파일 경로가 유효하지 않습니다.")
            } catch(e: InvalidCapacityException) {println(e.message)
            } catch(e: InvalidContentException) {println(e.message)}

        }
    }
}

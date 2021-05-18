package me

import kotlin.math.*


data class Coordinate(
    val x: Int,
    val y: Int,
    var distance: Double = 0.0
)

class SortCoordinate {
    fun getDistance(coordinate1: Coordinate, coordinate2: Coordinate): Double{
        return sqrt((coordinate1.x - coordinate2.x).toDouble().pow(2) + (coordinate1.y - coordinate2.y).toDouble().pow(2))
    }

    fun getSortedCoordinate(data: String): String? {
        try{
            val regex = """\(([ 0-9.]+),([ 0-9.]+)\)\(([ 0-9.]+),([ 0-9.]+)\)\(([ 0-9.]+),([ 0-9.]+)\)\(([ 0-9.]+),([ 0-9.]+)\)(\d+)""".toRegex() // 음수 생각안했다...
            val matchResult = regex.find(data)
            val (x1,y1,x2,y2,x3,y3,x4,y4,int) =  matchResult!!.destructured

            var sortedCoord = emptyList<Coordinate>()
            val coordList = listOf(
                Coordinate(x1.toInt(), y1.toInt()),
                Coordinate(x2.toInt(), y2.toInt()),
                Coordinate(x3.toInt(), y3.toInt()),
                Coordinate(x4.toInt(), y4.toInt())
            )
            for (index in coordList.indices){
                coordList[index].distance = getDistance(coordList[int.toInt()-1], coordList[index])
            }
            sortedCoord = coordList.sortedBy(Coordinate::distance)

            return "(${sortedCoord[0].x},${sortedCoord[0].y}) " +
                    "(${sortedCoord[1].x},${sortedCoord[1].y}) " +
                    "(${sortedCoord[2].x},${sortedCoord[2].y}) " +
                    "(${sortedCoord[3].x},${sortedCoord[3].y})"

            
        } catch(e: NullPointerException){
            return "다음을 확인해 주세요 : \n" +
                    "1. 괄호 및 쉼표를 이용하여 올바른 좌표표기를 하셨나요? \n" +
                    "2. 좌표 4개와 숫자 1개를 입력하셨나요?"
        } catch(e: NumberFormatException){
            return "정수를 넣어주세요."
        } catch(s: ArrayIndexOutOfBoundsException){
            return "알맞는 순번를 넣어주세요"
        }
    }
}


fun main(args: Array<String>){
    val inputData = readLine().toString().replace(" ", "")
    val result = SortCoordinate().getSortedCoordinate(inputData)
    println(result)
}

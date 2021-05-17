package me

import kotlin.math.*

data class Coordinate(
    val x: Int,
    val y: Int,
    var distance: Double = 0.0
)



class SortCoordinate {
    // input 데이터 -> 좌표평면 리스트 -> 거리 리스트 (소팅) -> 정렬후 스트링
    fun getDistance(coordinate1: Coordinate, coordinate2: Coordinate): Double{
        return sqrt((coordinate1.x - coordinate2.x).toDouble().pow(2) + (coordinate1.y - coordinate2.y).toDouble().pow(2))
    }

    fun getSortedCoordinate(data: String): String? {
        //1. decoding string input

        val regex = """.*(\d+).*(\d+).*(\d+).*(\d+).*(\d+).*(\d+).*(\d+).*(\d+).*(\d+).*""".toRegex()
        val matchResult = regex.find(data)
        val (x1,y1,x2,y2,x3,y3,x4,y4,int) =  matchResult!!.destructured


        //2. 리스트: 좌표평면 만들기
        val coordList: List<Coordinate> = listOf(Coordinate(x1.toInt(), y1.toInt()), Coordinate(x2.toInt(), y2.toInt()), Coordinate(x3.toInt(), y3.toInt()), Coordinate(x4.toInt(), y4.toInt()))


        //3. 리스트: 거리 만들기
        for (index in 0..3){
            coordList[index].distance = getDistance(coordList[int.toInt()], coordList[index])
        }

        //4. 거리 sorting
        //정렬 수정필요
        coordList.sortedBy(Coordinate::distance)
//        println(coordList[0])
//        println(coordList[1])
//        println(coordList[2])
//        println(coordList[3])


        //5. 좌표평면 sorting



        //6. output : 스트링으로
        // python end옵션추가 -> for
        return "(${coordList[0].x},${coordList[0].y}) (${coordList[1].x},${coordList[1].y}) (${coordList[2].x}, ${coordList[2].y}) (${coordList[3].x}, ${coordList[3].y})"
    }
}


fun main(args: Array<String>){
    val inputData = readLine().toString()
    val result = SortCoordinate().getSortedCoordinate(inputData)
    println(result)


}


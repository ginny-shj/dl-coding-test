package me

class SortedPoints {
    var sortedPoints = emptyList<Point>()


    fun sort(stringData: String) {
        try{
        val regex =
            """\(([+-]?[ 0-9.]+),([+-]?[ 0-9.]+)\)\(([+-]?[ 0-9.]+),([+-]?[ 0-9.]+)\)\(([+-]?[ 0-9.]+),([+-]?[ 0-9.]+)\)\(([+-]?[ 0-9.]+),[+-]?([ 0-9.]+)\)(\d+)""".toRegex()
        val matchResult = regex.find(stringData)
        val (x1, y1, x2, y2, x3, y3, x4, y4, index) = matchResult!!.destructured

        val points = listOf<Point>(
            Point(x1.toInt(), y1.toInt()),
            Point(x2.toInt(), y2.toInt()),
            Point(x3.toInt(), y3.toInt()),
            Point(x4.toInt(), y4.toInt())
        )
        val center = points[index.toInt() - 1]

        this.sortedPoints = points
            .asSequence()
            .map {
                it to it.getDistance(center)
            }
            .sortedBy { it.second }
            .map { it.first }
            .toList()
        } catch(e: NullPointerException){
            println("다음을 확인해 주세요 : \n" +
                    "1. 괄호 및 쉼표를 이용하여 올바른 좌표표기를 하셨나요? \n" +
                    "2. 좌표 4개와 숫자 1개를 입력하셨나요?")
        } catch(e: ArrayIndexOutOfBoundsException){
            println("알맞는 순번를 넣어주세요")
        } catch(e: NumberFormatException){
            println("정수를 넣어주세요.")
        }
    }


    override fun toString(): String {
        return "(${sortedPoints[0].x},${sortedPoints[0].y}) " +
                "(${sortedPoints[1].x},${sortedPoints[1].y}) " +
                "(${sortedPoints[2].x},${sortedPoints[2].y}) " +
                "(${sortedPoints[3].x},${sortedPoints[3].y})"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val listPoints = SortedPoints()
            listPoints.sort(args[0])
            if (listPoints.sortedPoints.size == 4) {
                println(listPoints)
            }
        }
    }
}

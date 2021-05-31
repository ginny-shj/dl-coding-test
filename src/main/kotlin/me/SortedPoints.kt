package me


class SortedPoints {
    var sortedPoints = emptyList<Point>()


    fun sort(stringData: String) {
        val regex = """\(([+-]?[ 0-9.]+),([+-]?[ 0-9.]+)\)\(([+-]?[ 0-9.]+),([+-]?[ 0-9.]+)\)\(([+-]?[ 0-9.]+),([+-]?[ 0-9.]+)\)\(([+-]?[ 0-9.]+),[+-]?([ 0-9.]+)\)(\d+)""".toRegex()
        val matchResult = regex.find(stringData)
        var (x1,y1,x2,y2,x3,y3,x4,y4,index) =  matchResult!!.destructured

        var points = mutableListOf<Point>(
            Point(x1.toInt(),y1.toInt()),
            Point(x2.toInt(),y2.toInt()),
            Point(x3.toInt(),y3.toInt()),
            Point(x4.toInt(),y4.toInt()))
        var center = points[index.toInt() -1]

        points.map{ it.getDistance(center) }
        this.sortedPoints = points.sortedBy{ it.d }
    }


    override fun toString(): String {
        return "(${sortedPoints[0].x},${sortedPoints[0].y}) " +
                "(${sortedPoints[1].x},${sortedPoints[1].y}) " +
                "(${sortedPoints[2].x},${sortedPoints[2].y}) " +
                "(${sortedPoints[3].x},${sortedPoints[3].y})"
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            val listofPoints = SortedPoints()
            listofPoints.sort(args[0])
            println(listofPoints)
        }
    }
}

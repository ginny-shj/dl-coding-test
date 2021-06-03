package me

import kotlin.math.pow

class Point(
    val x: Int,
    val y: Int,
){
    fun getDistance(centerPoint: Point) =  (this.x - centerPoint.x).toDouble().pow(2) + (this.y - centerPoint.y).toDouble().pow(2)
}

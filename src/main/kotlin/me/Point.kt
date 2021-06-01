package me

import kotlin.math.pow

class Point(
    val x: Int,
    val y: Int,
    var d: Double = 0.0
){
    fun getDistance(centerPoint: Point) {
        val distance: Double = (this.x - centerPoint.x).toDouble().pow(2) + (this.y - centerPoint.y).toDouble().pow(2)
        this.d = distance
    }
}
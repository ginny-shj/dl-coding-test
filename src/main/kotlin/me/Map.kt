package me


data class Map(val size: Int){
    var orderBW = true

    fun getMap(): List<MutableList<Int>>  {
        return  List(size) { MutableList(size) { 0 } }
    }
    fun orderCheck(){
        orderBW = !orderBW
    }

    private fun win5Check(
        mapBoard: List<MutableList<Int>>,
        dy: Int,
        dx: Int,
        y: Int,
        x: Int,
        player: Player
    ): Boolean {
        for (z in 1..4) {
            if (mapBoard[y + (dy * z)][x + (dx * z)] != player.color)  return false
        }
        return true //누군가가 이겼다.
    }
    fun winCheck(
        mapBoard: List<MutableList<Int>>,
        sizeLine: Int,
        player: Player
    ): Boolean {
        for (y in mapBoard.indices) { //y: 행
            for (x in mapBoard.indices) { //x: 열
                if (mapBoard[y][x] != player.color) continue
                if (x + 4 < sizeLine && win5Check(mapBoard, 0, 1, y, x, player)) return true
                if (y + 4 < sizeLine && win5Check(mapBoard, 1, 0, y, x, player)) return true
                if (x - 4 >= 0 && y - 4 >= 0 && win5Check(mapBoard, -1, -1, y, x, player)) return true
                if (x + 4 <= sizeLine && y - 4 >= 0 && win5Check(mapBoard, -1, 1, y, x,player)) return true
            }
        }
        return false
    }
}
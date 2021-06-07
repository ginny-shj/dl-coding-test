package me

data class Player (val color: Int) {

    fun getColor(integer: Int): String? {
        when (integer) {
            1 -> return "검은돌"
            2 -> return "흰돌"
            else -> return null
        }
    }
}
package me

import javax.swing.JOptionPane
import kotlin.system.exitProcess

class Popup {
    fun winPopup(player: Player){
        JOptionPane.showMessageDialog(null, "${player.getColor(player.color)}이 이겼습니다.")
        exitProcess(0)
    }
    fun putPopup(){
        JOptionPane.showMessageDialog(null, "다른 곳에 돌을 놓아주세요")
    }
}
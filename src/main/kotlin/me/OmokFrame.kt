package me
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*
import kotlin.math.round

//TODO : 1) UI - 바둑판가운데점, 순서안내, 2) config 파일 따로 만들기 / MVC로 만들기

class OmokFrame : JFrame() {

    var sizeStone: Int = 30
    var sizeLine: Int = 19

    val BLACK: Int = 1
    val WHITE: Int = 2

    val mapping = Map(sizeLine)
    val map = mapping.getMap()
    val players: List<Player> = listOf(Player(BLACK), Player(WHITE))
    val popup = Popup()

    init {
        this.setTitle("오목 게임")
        this.defaultCloseOperation = EXIT_ON_CLOSE
        val pannel = MyPannel()
        contentPane = pannel
        pannel.isFocusable = true
        pannel.background = Color(248,190,100)
        this.setSize(650, 650)
        this.isVisible = true
    }

    inner class MyPannel : JPanel() {
        var x_click: Int = -1
        var y_click: Int = -1

        init {
            addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(e:MouseEvent) {
                    if (sizeStone*1.5 <= e.x && e.x <= sizeStone*(sizeLine-0.5)
                        && sizeStone*1.5 <= e.y && e.y <= sizeStone*(sizeLine-0.5)){ //이 범위 내에 마우스가 클릭되었을 때,
                        val y = (round(e.x / sizeStone.toDouble()) - 1).toInt()
                        val x = (round(e.y / sizeStone.toDouble()) - 1).toInt()

                        if (map[x][y] == BLACK || map[x][y] == WHITE) { popup.putPopup()
                        } else{
                            if (mapping.orderBW) map[x][y] = BLACK
                            else map[x][y] = WHITE
                            mapping.orderCheck() //순서 바꿔주기
                            x_click = y
                            y_click = x
                        }
                    }
                    repaint()
                    for (i in players.indices){
                        if (mapping.winCheck(map, sizeLine, players[i])) {
                            popup.winPopup(players[i])
                    }
                    }
                }
            })
        }

        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)

            for (i in 0..sizeLine) {
                g.setColor(Color.BLACK)
                g.drawLine(sizeStone, sizeStone * i, sizeStone * sizeLine, sizeStone * i) //x: 행, y: 열
                g.drawLine(sizeStone * i, sizeStone, sizeStone * i, sizeStone * sizeLine) //x: 행, y: 열

                for (x in 0 until sizeLine) { //map 사이즈는 줄보다 한개씩 작음
                    for (y in 0 until sizeLine) {
                        when (map[y][x].toString()) {
                            1.toString() -> {
                                g.setColor(Color.BLACK)
                                g.fillOval(
                                    x * sizeStone + sizeStone / 2,
                                    y * sizeStone + sizeStone / 2,
                                    sizeStone - 1,
                                    sizeStone - 1
                                )
                            }
                            2.toString() -> {
                                g.setColor(Color.WHITE)
                                g.fillOval(
                                    x * sizeStone + sizeStone / 2,
                                    y * sizeStone + sizeStone / 2,
                                    sizeStone - 1,
                                    sizeStone - 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
package me

import spock.lang.Specification

class SortCoordinateKtTest extends Specification {
    def "SortCoordinate"(){
        when:
        def actual = new SortCoordinate().getSortedCoordinate(a)

        then:
        actual == expected

        where:
        a | expected
        "(1,1)(2,2)(3,3)(4,4)3" | "(3,3) (2,2) (4,4) (1,1)"
        "(1,1)(2,2)(4,4)(5,5)2" | "(2,2) (1,1) (4,4) (5,5)"
        "(-1,1)(2,2)(3,3)(4,4)3" | "(3,3) (2,2) (4,4) (-1,1)"

        "(1,1)(2,2)(3,3)3" | "다음을 확인해 주세요 : \n" +
                "1. 괄호 및 쉼표를 이용하여 올바른 좌표표기를 하셨나요? \n" +
                "2. 좌표 4개와 숫자 1개를 입력하셨나요?"

        "(1.1,1)(2,2)(3,3)(4,4)3" | "정수를 넣어주세요."
        "(1.1,1)(2,2)(3,3.4)(4,4)3" | "정수를 넣어주세요."

        "(1,1)(2,2)(3,3)(4,4)5" | "알맞는 순번를 넣어주세요"


    }
}

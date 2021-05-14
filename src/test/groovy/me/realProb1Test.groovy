package me

import spock.lang.Specification

class realProb1Test extends Specification {
    def "realProb1"(){
//        given:
//        def a = "2+3"
//        def expected = 5

        when:
        def actual = new realProb1().Calculator(a)

        then:
        actual == expected

        //디버그
        where:
        a | expected
        "1+1" | 2
        "2*3" | 6
        "3/2" | 1.5
        "200*300" | 200*300
//        " 2+3" | "공백을 제거해주세요"
//        "2//3" | null

    }

}

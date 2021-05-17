package me

import spock.lang.Specification

class Prob1Test extends Specification {
    def Calculator(){
        when:
        def actual = new Calculator().calculatingString(a)

        then:
        actual == expected

        where:
        a | expected

        "1+1" | 2
        "2*3" | 6
        "3/2" | 1.5
        "200*300" | 200*300
        "2//3" | null
        "2++3" | null

    }

}

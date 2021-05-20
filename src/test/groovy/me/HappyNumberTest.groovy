package me

import spock.lang.Specification

class HappyNumberTest extends Specification {
    def "HappyNumber"(){
        when:
        def actual = new HappyNumber().determineHappy(a)

        then:
        actual == expected

        where:
        a | expected
        "4" | "UNHAPPY"
        "16" | "UNHAPPY"
        "20" | "UNHAPPY"
        "5" | "UNHAPPY"
        "9" | "UNHAPPY"
        "12" | "UNHAPPY"

        "19" | "HAPPY"
        "7" | "HAPPY"
        "10" | "HAPPY"
        "13" | "HAPPY"


        "1000000001" | "1과 1,000,000,000 사이의 수를 입력하세요."
        "-1" | "1과 1,000,000,000 사이의 수를 입력하세요."

        "2ffefe" | "정수를 입력하세요"
        "1.34293479" | "정수를 입력하세요"

    }

}

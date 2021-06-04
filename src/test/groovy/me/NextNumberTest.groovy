package me

import spock.lang.Specification

class NextNumberTest extends Specification {
    def "NextNumber"() {
        when:
        def actual = new NextNumber(a).findNext()

        then:
        actual == expected

        where:
        a    | expected
        "3"  | "4"
        "9"  | "11"
        "99" | "111"
        "123" | "124"
        "99" | "111"

    }
    def "예외_0포함"() {
        given:
        def a = "100"

        when:
        def actual = new NextNumber(a).validateInput()

        then:
        def e = thrown(InputNotValidException.class)
        e.message == "0을 제외하고 입력해 주세요"
    }


    def "예외_범위외"() {
        given:
        def a = "1999999999"

        when:
        def actual = new NextNumber(a).validateInput()

        then:
        def e = thrown(InputNotValidException.class)
        e.message == "1과 1,000,000 사이의 값을 입력해 주세요"
    }

}
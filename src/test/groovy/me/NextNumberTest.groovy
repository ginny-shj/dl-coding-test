package me

import spock.lang.Specification

class NextNumberTest extends Specification {
    def "NextNumber"(){
        when:
        def actual = new NextNumber().findNext(a)

        then:
        actual == expected

        where:
        a | expected
        "3" | "4"
        "9" | "11"
        "99" | "111"
        "123" | "124"
        "99" | "111"

        "100" | "0을 제외하고 입력해 주세요"
        "101" | "0을 제외하고 입력해 주세요"
        "138340" | "0을 제외하고 입력해 주세요"

        "1111111" | "1과 1,000,000 사이의 값을 입력해 주세요"
        "-1" | "1과 1,000,000 사이의 값을 입력해 주세요"

        "342f" | "1과 1,000,000 사이의 정수를 입력해 주세요"
        "abcd" | "1과 1,000,000 사이의 정수를 입력해 주세요"
        "1823791827938719284" | "1과 1,000,000 사이의 정수를 입력해 주세요"
    }
}

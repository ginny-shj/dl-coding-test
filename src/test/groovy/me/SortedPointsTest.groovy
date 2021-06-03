package me

import spock.lang.Specification

class SortedPointsTest extends Specification {
    def "testMain"() {

        when:
        def points = new SortedPoints()
        points.sort(a)
        def actual = points.toString()

        then:
        actual == expected

        where:
        a | expected
        "(1,1)(2,2)(3,3)(4,4)3" | "(3,3) (2,2) (4,4) (1,1)"
        "(1,1)(2,2)(4,4)(5,5)2" | "(2,2) (1,1) (4,4) (5,5)"
        "(-1,1)(2,2)(3,3)(4,4)3" | "(3,3) (2,2) (4,4) (-1,1)"

    }
//    def "정수외의 입력"(){
//
//        given:
//        def a = "(1.1,1)(2,2)(3,3)(4,4)3"
//        def points = new SortedPoints()
//
//        when:
//        points.sort(a)
//
//        then:
//        def e = thrown(NumberFormatException.class)
//        e.message == "정수를 넣어주세요."
//    }
}
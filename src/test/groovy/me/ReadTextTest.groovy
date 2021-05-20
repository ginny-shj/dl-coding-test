package me

import spock.lang.Specification

class ReadTextTest extends Specification {
    def "ReadText"(){
        when:
        def actual = new ReadText().readFile(a)

        then:
        actual == expected

        where:
        a | expected
        "/home/anypoint/test.txt" | "I\nim\nin\nno\nbut\nmore\nmust\ncannot"
        "/home/anypoint/test2.txt" |"a\nsf\ndfj\nweif\nefaleif"
        "/home/anypoint/test3.txt" | "I\ndid"

        "/home/anypoint/test4.txt" | "영문 파일을 찾을 수 없거나, 용량이 초과되었습니다."
        "/home/anypoint/test5.txt" | "영문 파일을 찾을 수 없거나, 용량이 초과되었습니다."
        "/home/anypoint/abc.txt" | "영문 파일을 찾을 수 없거나, 용량이 초과되었습니다."
    }

}

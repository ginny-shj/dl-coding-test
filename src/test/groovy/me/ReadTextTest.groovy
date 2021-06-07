package me

import spock.lang.Specification

class ReadTextTest extends Specification {
    def "메인함수"(){
        when:
        def sortList = new SortList(new ReadFile(filePath).readFile())
        sortList.sorting()
        def actual = sortList.toString()

        then:
        actual == expected

        where:
        filePath | expected
        "/home/anypoint/test.txt" | "I\nim\nin\nno\nbut\nmore\nmust\ncannot\n"
        "/home/anypoint/test2.txt" |"a\nsf\ndfj\nweif\nefaleif\n"
        "/home/anypoint/test3.txt" | "I\ndid\n"
    }

    def "에러_파일용량"(){
        given:
        def filePath = "/home/anypoint/text4.txt"

        when:
        def actual = new ReadFile(filePath).validCapacity()

        then:
        def e = thrown(InvalidCapacityException.class)
        e.message == "1메가 이하의 파일만 가능합니다."
    }

    def "에러_알파벳"(){
        given:
        def filePath = "/home/anypoint/text1.txt"

        when:
        def actual = new SortList(new ReadFile(filePath).readFile()).validContent()

        then:
        def e = thrown(InvalidContentException.class)
        e.message == "알파벳만 써 주세요."
    }

    def "에러_파일경로"(){
        given:
        def filePath = "/home/anypoint/text111.txt"

        when:
        def actual = new ReadFile(filePath).readFile()

        then:
        def e = thrown(FileNotFoundException.class)
        e.message == "${filePath} (No such file or directory)"

    }

}

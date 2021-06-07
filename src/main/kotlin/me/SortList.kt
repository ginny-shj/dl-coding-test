package me

class SortList (
    var list: List<String>
    ){

    private fun getLength(string: String): Int{
        return string.length
    }

    fun sorting() : List<String?> {
        return list.asSequence()
                .sortedBy { it } //1. 알파벳순
                .map{ it to getLength(it) }
                .sortedBy{it.second} //2. 길이순
                .map { it.first }
                .toList().also { list = it }
    }

    fun validContent(){
        for (element in list) if (!element.matches(Regex("""/^[A-Za-z]+$/"""))) {
            throw InvalidContentException("알파벳만 써 주세요.")
        }
    }

    override fun toString() : String {
        var str = ""
        for (element in list) str += element + "\n"
        return str
    }

}
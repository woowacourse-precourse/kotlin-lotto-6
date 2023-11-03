package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        while (true) {
            try {
                require(numbers.distinct().size == 6)
                break
            } catch (e: IllegalArgumentException) {
                println("[Error] 6개의 숫자를 입력해주세요.")
                throw IllegalArgumentException()
            }
        }
    }
    fun printnumbers()
    {
        val nums = numbers.joinToString(", ")
        println("[$nums]")
    }

    fun checklotto(winningnumbers: List<Int>, bonus: Int): MatchCount
    {
        val matchnumber = winningnumbers.intersect(numbers.toSet()).count()

        return when (matchnumber) {
            0 -> MatchCount.NONE
            1 -> MatchCount.ONE
            2 -> MatchCount.TWO
            3 -> MatchCount.THREE
            4 -> MatchCount.FOUR
            5 -> if (bonus in winningnumbers) MatchCount.FIVEBONUS else MatchCount.FIVE
            6 -> MatchCount.ALL
            else -> throw IllegalArgumentException("유효한 숫자가 아닙니다.")
        }
    }
}

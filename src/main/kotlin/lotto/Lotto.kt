package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == 6)
    }
    
    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun matchWith(userNumbers: List<Int>, bonusNumber: Int): Prize {
        val matchedNumbers = numbers.intersect(userNumbers.toSet())
        val bonusMatch = numbers.contains(bonusNumber)

        return when (matchedNumbers.size) {
            6 -> Prize.FIRST
            5 -> if (bonusMatch) Prize.SECOND else Prize.THIRD
            4 -> Prize.FOURTH
            3 -> Prize.FIFTH
            else -> Prize.NONE
        }
    }
}
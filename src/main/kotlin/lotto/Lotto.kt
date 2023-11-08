package lotto
enum class Prize(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0)
}

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { throw IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.") }
        require(numbers.all { it in 1..45 }) { throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.") }
        require(numbers.toSet().size == 6) { throw IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.") }
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun countMatch(winningNumbers: List<Int>, bonusNumber: Int): Prize {
        val matchCount = numbers.count { it in winningNumbers }
        return when (matchCount) {
            6 -> Prize.FIRST
            5 -> if (numbers.contains(bonusNumber)) Prize.SECOND else Prize.THIRD
            4 -> Prize.FOURTH
            3 -> Prize.FIFTH
            else -> Prize.NONE
        }
    }
}
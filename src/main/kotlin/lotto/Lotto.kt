package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun calculateResult(winningNumbers: List<Int>, bonusNumber: Int): Rank {
        val matchCount = numbers.intersect(winningNumbers).size
        val bonusMatch = numbers.contains(bonusNumber)
        return Rank.findRank(matchCount, bonusMatch)
    }
    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
        }

    fun matchCount(winningNumbers: List<Int>): Int {
        return getSortedNumbers().intersect(winningNumbers).size
        }
    }

enum class Rank(//등수 조건 설정
    val matchCount: Int,
    val prizeMoney: Int,
    val needBonus: Boolean = false
    ) {
        FIRST(6, 2_000_000_000),
        SECOND(5, 30_000_000, true),
        THIRD(5, 1_500_000),
        FOURTH(4, 50_000),
        FIFTH(3, 5_000),
        MISS(0, 0);

    companion object {//등수
        fun findRank(matchCount: Int, bonusMatch: Boolean): Rank {
            return values().find { it.matchCount == matchCount && it.needBonus == bonusMatch }
                ?: values().find { it.matchCount == matchCount }
                ?: MISS
            }
        }
    }

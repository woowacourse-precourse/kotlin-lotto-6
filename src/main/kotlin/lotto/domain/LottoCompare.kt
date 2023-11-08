package lotto.domain


class LottoCompare(private val numbers: MutableList<Lotto>) {
    fun compare(winning: List<Int>): MutableList<Int> {
        val winningCount: MutableList<Int> = mutableListOf()
        for (index in numbers.indices) {
            winningCount.add(winningResult(winning, numbers[index]))
        }
        return winningCount
    }

    fun compareBonus(bonus: Int): Int {
        var count = 0
        for (index in numbers.indices) {
            count = bonusResult(bonus, numbers[index])
        }
        return count
    }

    private fun winningResult(winning: List<Int>, i: Lotto): Int {
        val intersectNumber: Set<Int> = i.intersect(winning)
        return intersectNumber.size
    }

    private fun bonusResult(bonus: Int, i: Lotto): Int {
        var bonusCount = 0
        if (i.contains(bonus)) {
            bonusCount++
        }
        return bonusCount
    }
}
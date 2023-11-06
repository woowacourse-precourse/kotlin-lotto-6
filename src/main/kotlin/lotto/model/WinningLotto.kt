package lotto.model

// 당첨 로또
class WinningLotto(private val numbers: MutableSet<Int>) {

    fun addBonusNumber(num: Int) = numbers.add(num)

    fun getWinningNumbers(
        lotto: MutableSet<Int>
    ): Int {
        return countWinningNumbers(numbers.intersect(lotto))
    }

    private fun countWinningNumbers(
        intersection: Set<Int>
    ): Int = intersection.size
}
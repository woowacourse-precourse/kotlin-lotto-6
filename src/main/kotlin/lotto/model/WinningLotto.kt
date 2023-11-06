package lotto.model

// 당첨 로또
class WinningLotto(private val numbers: MutableSet<Int>) {

    fun addBonusNumber(num: Int) = numbers.add(num)

    fun getWinningNumber(
        lotto: MutableSet<Int>
    ): Int {
        return countWinningNumber(numbers.intersect(lotto))
    }

    private fun countWinningNumber(
        intersection: Set<Int>
    ): Int = intersection.size
}
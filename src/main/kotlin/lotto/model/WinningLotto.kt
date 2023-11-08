package lotto.model

// 당첨 로또 번호
class WinningLotto(
    private val numbers: Set<Int>,
    private val bonusNumber: Int
) {

    fun checkWinningBonusNumber(
        lottoNumber: Set<Int>
    ): Boolean = lottoNumber.contains(bonusNumber)

    fun getWinningNumber(
        lottoNumber: Set<Int>
    ): Int = countWinningNumbers(numbers.intersect(lottoNumber))

    private fun countWinningNumbers(
        intersection: Set<Int>
    ): Int = intersection.count()

}
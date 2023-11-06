package lotto.model

// 당첨 로또 번호
class WinningLotto(
    private val numbers: Set<Int>,
    private val bonusNumber : Int
) {

    fun checkBonusNumber(
        lottoNumber: Set<Int>
    ): Boolean {
        return getNotWinningNumbers(lottoNumber).contains(bonusNumber)
    }

    fun getWinningNumber(
    lottoNumber: Set<Int>
    ): Int {
        return countWinningNumbers(numbers.intersect(lottoNumber))
    }

    private fun getNotWinningNumbers(
        lottoNumber: Set<Int>
    ): Set<Int> = numbers.subtract(lottoNumber)

    private fun countWinningNumbers(
        intersection: Set<Int>
    ): Int = intersection.size

    companion object {

    }
}
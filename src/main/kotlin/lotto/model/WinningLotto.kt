package lotto.model

// 당첨 로또 번호
class WinningLotto(
    private val numbers: Set<Int>,
    private val bonusNumber: Int
) {

    fun checkWinningBonusNumber(
        lottoNumber: Set<Int>
    ): Boolean = getNotWinningNumbers(lottoNumber).contains(bonusNumber)

    fun getWinningNumber(
        lottoNumber: Set<Int>
    ): Int = countWinningNumbers(numbers.intersect(lottoNumber))

    // 담청 번호를 제외한 목록을 반환하는 기능을 합니다.
    private fun getNotWinningNumbers(
        lottoNumber: Set<Int>
    ): Set<Int> = lottoNumber.subtract(numbers)

    private fun countWinningNumbers(
        intersection: Set<Int>
    ): Int = intersection.size

}
package lotto

class LottoInspector {

    private fun checkLotto(lotto: Lotto, winningNumber: List<Int>, bonusNumber: Int) {
        val lottoNumber = lotto.getLottoNumber()
    }

    private fun compareLotto(lottoNumber: List<Int>, winningNumber: List<Int>): Int {
        val mixedLotto = lottoNumber + winningNumber
        return getMatchedNumbers(mixedLotto)
    }

    private fun getMatchedNumbers(mixedLotto: List<Int>): Int {
        val distinctMixedLotto = mixedLotto.distinct()
        return mixedLotto.size - distinctMixedLotto.size
    }

}
package lotto

class LottoInspector {

    private fun checkLotto(lotto: Lotto, winningNumber: List<Int>, bonusNumber: Int): Int {
        val lottoNumber = lotto.getLottoNumber()
        val lottoResult = compareLotto(lottoNumber, winningNumber)
        when (lottoResult) {
            LottoMatched.SIX.matchedNumbers -> return 1
            LottoMatched.FIVE.matchedNumbers -> return bonusCheck(lotto, bonusNumber)
            LottoMatched.FOUR.matchedNumbers -> return 4
            LottoMatched.THREE.matchedNumbers -> return 5
        }
        return 0
    }

    private fun bonusCheck(lotto: Lotto, bonusNumber: Int): Int {
        val lottoNumbers = lotto.getLottoNumber()
        if (lottoNumbers.contains(bonusNumber)) {
            return 2
        }
        return 3
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
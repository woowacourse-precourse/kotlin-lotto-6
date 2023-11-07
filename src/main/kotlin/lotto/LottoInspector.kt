package lotto

class LottoInspector {

    private fun showLottoResult(issuedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        val lottoResultList = makeLottoResultList(issuedLotto,winningNumber,bonusNumber)
    }

    private fun makeLottoResultList(issuedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int): Array<Int> {
        val lottoResultList = Array(6) { 0 }
        for (lotto in issuedLotto) {
            val lottoResult = checkLotto(lotto,winningNumber,bonusNumber)
            lottoResultList[lottoResult]++
        }
        return lottoResultList
    }

    private fun checkLotto(lotto: Lotto, winningNumber: List<Int>, bonusNumber: Int): Int {
        val lottoNumber = lotto.getLottoNumber()
        val lottoResult = compareLotto(lottoNumber, winningNumber)
        when (lottoResult) {
            LottoMatched.SIX.matchedNumbers -> return LottoAward.FIRST.reward
            LottoMatched.FIVE.matchedNumbers -> return bonusCheck(lotto, bonusNumber)
            LottoMatched.FOUR.matchedNumbers -> return LottoAward.FOURTH.reward
            LottoMatched.THREE.matchedNumbers -> return LottoAward.FIFTH.reward
        }
        return LottoAward.NO_REWARD.reward
    }

    private fun bonusCheck(lotto: Lotto, bonusNumber: Int): Int {
        val lottoNumbers = lotto.getLottoNumber()
        if (lottoNumbers.contains(bonusNumber)) {
            return LottoAward.SECOND.reward
        }
        return LottoAward.THIRD.reward
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
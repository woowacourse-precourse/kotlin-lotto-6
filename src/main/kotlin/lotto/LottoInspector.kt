package lotto

class LottoInspector {

    fun showLottoResult(issuedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        val lottoResultList = makeLottoResultList(issuedLotto,winningNumber,bonusNumber)
        printLottoResult(lottoResultList)
        printEarningRate(lottoResultList,issuedLotto)
    }

    private fun makeLottoResultList(issuedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int): Array<Int> {
        val lottoResultList = Array(6) { 0 }
        for (lotto in issuedLotto) {
            val lottoResult = checkLotto(lotto,winningNumber,bonusNumber)
            lottoResultList[lottoResult]++
        }
        return lottoResultList
    }

    private fun printLottoResult(lottoResultList: Array<Int>) {
        println("당첨 통계")
        println("---")
        println("${LottoMatched.THREE.matchedNumbers}개 일치 " +
                "(${LottoRewardMoney.FIFTH.rewardMoney}) - ${lottoResultList[LottoAward.FIFTH.reward]}개")
        println("${LottoMatched.FOUR.matchedNumbers}개 일치 " +
                "(${LottoRewardMoney.FOURTH.rewardMoney}) - ${lottoResultList[LottoAward.FOURTH.reward]}개")
        println("${LottoMatched.FIVE.matchedNumbers}개 일치 " +
                "(${LottoRewardMoney.THIRD.rewardMoney}) - ${lottoResultList[LottoAward.THIRD.reward]}개")
        println("${LottoMatched.FIVE.matchedNumbers}개 일치, 보너스 볼 일치 " +
                "(${LottoRewardMoney.SECOND.rewardMoney}) - ${lottoResultList[LottoAward.SECOND.reward]}개")
        println("${LottoMatched.SIX.matchedNumbers}개 일치 " +
                "(${LottoRewardMoney.FIRST.rewardMoney}) - ${lottoResultList[LottoAward.FIRST.reward]}개")
    }

    private fun printEarningRate(lottoResultList: Array<Int>, issuedLotto: List<Lotto>) {
        val earningRate = getEarningRate(lottoResultList,issuedLotto)
        println("총 수익률은 ${earningRate}%입니다.")
    }

    private fun getEarningRate(lottoResultList: Array<Int>, issuedLotto: List<Lotto>): Double {
        val earnedMoney = getEarnedMoney(lottoResultList)
        val purchasedMoney = issuedLotto.size * 1000
        return earnedMoney.toDouble() / purchasedMoney.toDouble()
    }

    private fun getEarnedMoney(lottoResultList: Array<Int>): Int {
        return getRewardMoneyToInt(LottoRewardMoney.FIRST.rewardMoney) * lottoResultList[LottoAward.FIRST.reward] +
                getRewardMoneyToInt(LottoRewardMoney.SECOND.rewardMoney) * lottoResultList[LottoAward.SECOND.reward] +
                getRewardMoneyToInt(LottoRewardMoney.THIRD.rewardMoney) * lottoResultList[LottoAward.THIRD.reward] +
                getRewardMoneyToInt(LottoRewardMoney.FOURTH.rewardMoney) * lottoResultList[LottoAward.FOURTH.reward] +
                getRewardMoneyToInt(LottoRewardMoney.FIFTH.rewardMoney) * lottoResultList[LottoAward.FIFTH.reward]
    }

    private fun getRewardMoneyToInt(lottoRewardMoney: String): Int {
        lottoRewardMoney.replace("원","")
        lottoRewardMoney.replace(",","")
        return lottoRewardMoney.toInt()
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
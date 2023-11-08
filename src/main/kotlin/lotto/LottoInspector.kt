package lotto

import kotlin.math.round

class LottoInspector {

    fun showLottoResult(issuedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        val lottoResultList = makeLottoResultList(issuedLotto,winningNumber,bonusNumber)
        printLottoResult(lottoResultList)
        printEarningRate(lottoResultList,issuedLotto)
    }

    private fun makeLottoResultList(issuedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int): Array<Int> {
        val lottoResultList = Array(LOTTO_RESULT_LIST_SIZE) { ZERO }
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
                "(${LottoRewardMoney.FIFTH.rewardMoney}원) - ${lottoResultList[LottoAward.FIFTH.reward]}개")
        println("${LottoMatched.FOUR.matchedNumbers}개 일치 " +
                "(${LottoRewardMoney.FOURTH.rewardMoney}원) - ${lottoResultList[LottoAward.FOURTH.reward]}개")
        println("${LottoMatched.FIVE.matchedNumbers}개 일치 " +
                "(${LottoRewardMoney.THIRD.rewardMoney}원) - ${lottoResultList[LottoAward.THIRD.reward]}개")
        println("${LottoMatched.FIVE.matchedNumbers}개 일치, 보너스 볼 일치 " +
                "(${LottoRewardMoney.SECOND.rewardMoney}원) - ${lottoResultList[LottoAward.SECOND.reward]}개")
        println("${LottoMatched.SIX.matchedNumbers}개 일치 " +
                "(${LottoRewardMoney.FIRST.rewardMoney}원) - ${lottoResultList[LottoAward.FIRST.reward]}개")
    }

    private fun printEarningRate(lottoResultList: Array<Int>, issuedLotto: List<Lotto>) {
        val earningRate = getEarningRate(lottoResultList,issuedLotto)
        println("총 수익률은 ${earningRateToPercent(earningRate)}%입니다.")
    }

    private fun getEarningRate(lottoResultList: Array<Int>, issuedLotto: List<Lotto>): Double {
        val earnedMoney = getEarnedMoney(lottoResultList)
        val purchasedMoney = issuedLotto.size * LOTTO_PRICE
        return earnedMoney.toDouble() / purchasedMoney.toDouble()
    }

    private fun earningRateToPercent(earningRate: Double): Double {
        return round(earningRate * THOUSAND) / TEN
    }

    private fun getEarnedMoney(lottoResultList: Array<Int>): Int {
        return getRewardMoneyToInt(LottoRewardMoney.FIRST.rewardMoney) * lottoResultList[LottoAward.FIRST.reward] +
                getRewardMoneyToInt(LottoRewardMoney.SECOND.rewardMoney) * lottoResultList[LottoAward.SECOND.reward] +
                getRewardMoneyToInt(LottoRewardMoney.THIRD.rewardMoney) * lottoResultList[LottoAward.THIRD.reward] +
                getRewardMoneyToInt(LottoRewardMoney.FOURTH.rewardMoney) * lottoResultList[LottoAward.FOURTH.reward] +
                getRewardMoneyToInt(LottoRewardMoney.FIFTH.rewardMoney) * lottoResultList[LottoAward.FIFTH.reward]
    }

    private fun getRewardMoneyToInt(lottoRewardMoney: String): Int {
        return lottoRewardMoney.replace(",","").toInt()
    }

    fun checkLotto(lotto: Lotto, winningNumber: List<Int>, bonusNumber: Int): Int {
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

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_RESULT_LIST_SIZE = 6
        const val ZERO = 0
        const val THOUSAND = 1000
        const val TEN = 10
    }
}
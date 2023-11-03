package lotto.domain

import kotlin.math.*
import lotto.constant.Constant

object Winning {
    private val winningRateCount = mutableListOf<Int>()
    private val winningRateInfor = mutableListOf<LottoInfor>()

    enum class LottoInfor(val correct: Int, val price :Int, val bonusCheck: Boolean) {
        FIRST(6, 2000000000, false),
        SECOND(5, 30000000, true),
        THIRD(5, 1500000, false),
        FOURTH(4, 50000, false),
        FIFTH(3, 5000, false),
        NOTHING(0,0,false)
    }

    fun getWinningRateCount(): MutableList<Int> {
        return winningRateCount
    }

    private fun setWinningRateCountPerInfor(lottoInfor: LottoInfor) {
        when(lottoInfor) {
            LottoInfor.FIRST -> winningRateCount[Constant.WINNING_RATE_FIRST_INDEX]++
            LottoInfor.SECOND -> winningRateCount[Constant.WINNING_RATE_SECOND_INDEX]++
            LottoInfor.THIRD -> winningRateCount[Constant.WINNING_RATE_THIRD_INDEX]++
            LottoInfor.FOURTH -> winningRateCount[Constant.WINNING_RATE_FOURTH_INDEX]++
            LottoInfor.FIFTH -> winningRateCount[Constant.WINNING_RATE_FIFTH_INDEX]++
            LottoInfor.NOTHING -> return
        }
    }

    fun setWinningRateCount() {
        setWinningRateInforCount()
        for(winningInfor in winningRateInfor) {
            setWinningRateCountPerInfor(winningInfor)
        }
    }

    private fun setWinningRate(correctCount: Int, correctBonus: Boolean): LottoInfor {
        when(correctCount) {
            LottoInfor.FIRST.correct -> return LottoInfor.FIRST
            LottoInfor.FOURTH.correct -> return LottoInfor.FOURTH
            LottoInfor.FIFTH.correct -> return LottoInfor.FIFTH
        }
        if(correctCount == LottoInfor.SECOND.correct && correctBonus)
            return LottoInfor.SECOND
        if(correctCount == LottoInfor.SECOND.correct && !correctBonus)
            return LottoInfor.THIRD
        return LottoInfor.NOTHING
    }

    private fun initWinningRateCount() {
        for(i in Constant.INDEX_START..Constant.WINNING_RATE_COUNT)
            winningRateCount.add(Constant.WINNING_RATE_INIT_COUNT)
    }

    private fun setWinningRateInforCount() {
        val lottoSetList = LottoSet.getLottoSet()
        initWinningRateCount()
        for(lotto in lottoSetList) {
            winningRateInfor.add(setWinningRate(compareNumberWithWinningNumber(lotto),compareNumberWithBonusNumber(lotto)))
        }
    }

    fun calculateEarningRate(lottoCount: Int): Double {
        var sum=0
        for(winningInfor in winningRateInfor) {
            sum += winningInfor.price
        }
        if(sum==0) return 0.0
        val result = (sum.toDouble()/(Constant.PRICE_PER_LOTTO * lottoCount)) * 100
        return round(result*10)/10
    }

    private fun compareNumberWithWinningNumber(lotto: Lotto): Int {
        //여기 수정 필요
        var count=Constant.WINNING_RATE_INIT_COUNT
        for(number in lotto.getNumberPerLotto()) {
            if(WinningNumber.getWinningNumbers().contains(number))
                count++
        }
        return count
    }

    private fun compareNumberWithBonusNumber(lotto: Lotto): Boolean {
        if(lotto.getNumberPerLotto().contains(BonusNumber.getBonusNumber()))
            return true
        return false
    }
}
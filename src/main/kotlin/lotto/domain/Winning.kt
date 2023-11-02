package lotto.domain

object Winning {
    private val winningRateCount = mutableListOf<Int>(0,0,0,0,0)

    enum class LottoInfor(val correct: Int, val bonusCheck: Boolean) {
        FIRST(6, false),
        SECOND(5, true),
        THIRD(5, false),
        FOURTH(4, false),
        FIFTH(3, false),
    }

    fun getWinningRateCount(): MutableList<Int> {
        return winningRateCount
    }

    private fun setWinningRateCountPerLotto(correctCount: Int, correctBonus: Boolean) {
        when(correctCount) {
            LottoInfor.FIRST.correct -> winningRateCount[0]++
            LottoInfor.SECOND.correct -> winningRateCount[1]++
            LottoInfor.THIRD.correct -> winningRateCount[2]++
            LottoInfor.FOURTH.correct -> winningRateCount[3]++
            LottoInfor.FIFTH.correct -> winningRateCount[4]++
        }
        if(!correctBonus)
            winningRateCount[1]--
    }

    fun setWinningRateCount() {
        val lottoSetList = LottoSet.getLottoSet()
        for(lotto in lottoSetList) {
            setWinningRateCountPerLotto(compareNumberWithWinningNumber(lotto),compareNumberWithBonusNumber(lotto))
        }
    }

    private fun compareNumberWithWinningNumber(lotto: Lotto): Int {
        //여기 수정 필요
        var count=0
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
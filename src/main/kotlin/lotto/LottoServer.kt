package lotto

import camp.nextstep.edu.missionutils.Randoms
import client.Client
import constants.*

class LottoServer {
    private val client = Client()
    private val lottoList = mutableListOf<Lotto>()
    fun start() {
        val count = client.inputBuyMoneyToCount()
        createLottoRepeatByCount(count)
        client.outputUsersLotto(lottoList)
        val winNumberList = client.inputWinNumberList()
        val bonusNumber = client.inputBonusNumber()
        val winPrizeList = computeWinPrize(winNumberList, bonusNumber)
        client.outputWinPrize(winPrizeList)
        val rateOfReturn = computeRateOfReturn(winPrizeList, count)
    }


    private fun computeRateOfReturn(winPrizeList: List<WinState>, count: Int): Int {
        val userMoney = count * 1000
        val totalReturn =
            THREE_PRIZE_MONEY * winPrizeList.count { it == WinState.THREE }
        +FOUR_PRIZE_MONEY * winPrizeList.count { it == WinState.THREE }
        +FIVE_PRIZE_MONEY * winPrizeList.count { it == WinState.FIVE }
        +FIVE_WITH_BONUS_PRIZE_MONEY * winPrizeList.count { it == WinState.FIVEPLUSBONUS }
        +SIX_PRIZE_MONEY * winPrizeList.count { it == WinState.SIX }

        return (totalReturn / userMoney) * 100
    }

    private fun computeWinPrize(winNumberList: List<Int>, bonusNumber: Int): List<WinState> {
        return lottoList.map { lotto ->
            lotto.computeWinState(winNumberList, bonusNumber)
        }
    }

    private fun createLottoRepeatByCount(count: Int) {
        repeat(count) {
            val lotto = createLotto()
            insertLottoToList(lotto)
        }
    }

    private fun insertLottoToList(lotto: Lotto) {
        lottoList.add(lotto)
    }

    private fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}
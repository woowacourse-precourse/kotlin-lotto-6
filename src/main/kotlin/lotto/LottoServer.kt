package lotto

import camp.nextstep.edu.missionutils.Randoms
import client.Client

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
        println(winPrizeList)
    }

    private fun computeWinPrize(winNumberList: List<Int>, bonusNumber: Int): List<WinState> {
        return lottoList.map { lotto ->
            lotto.computeWinState(winNumberList,bonusNumber)
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
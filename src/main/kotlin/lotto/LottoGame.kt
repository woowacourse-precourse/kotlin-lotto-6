package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.view.Input
import lotto.view.Output

class LottoGame {
    private var matchCountList = mutableListOf(0,0,0,0,0)

    fun start() {
        val money = Input().inputMoney().toInt()
        val lottoCount = getLottoCount(money)
        val lottoList = getLotto(lottoCount)

        Output().outputLottos(lottoList)

        val winningNum = Input().inputWinningNum()
        val bonusNum = Input().inputBonusNum()

        lottoList.forEach { checkLottoAndWinningNumMatch(it,winningNum,bonusNum) }

        Output().outputMatchCount(matchCountList)

    }


    private fun getLottoCount(money: Int): Int = money / 1000

    private fun getLotto(lottoCount: Int): List<List<Int>> {
        val lottoList = List(lottoCount) {
            Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        }
        lottoList.forEach { Lotto(it) }
        return lottoList
    }

    private fun checkLottoAndWinningNumMatch(lotto: List<Int>, winningNum: String, bonusNum: String) {
        val winningNumList = winningNum.split(",").map { it.toInt() }.toSet()
        val bonusNumToInt = bonusNum.toInt()
        val match = lotto.intersect(winningNumList).size

        when (match) {
            3 -> matchCountList[0]++
            4 -> matchCountList[1]++
            5 -> if (lotto.contains(bonusNumToInt)) matchCountList[3]++ else matchCountList[2]++
            6 -> matchCountList[4]++
        }
    }
}

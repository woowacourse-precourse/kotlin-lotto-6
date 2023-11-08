package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.view.Input

class LottoGame {
    fun start() {
        val money = Input().inputMoney().toInt()
        val lottoCount = getLottoCount(money)
        val lottoList = getLotto(lottoCount)
        lottoList.forEach { println(it) }

    }


    private fun getLottoCount(money: Int): Int = money / 1000

    private fun getLotto(lottoCount: Int): List<List<Int>> {
        println()
        println("${lottoCount}개를 구매했습니다.")
        val lottoList = List(lottoCount){
            Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        }
        return lottoList
    }
}
package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.view.Input

class LottoGame {
    var threeMatch = 0
    var fourMatch = 0
    var fiveMatch = 0
    var fiveBonusMatch = 0
    var sixMatch = 0

    fun start() {
        val money = Input().inputMoney().toInt()
        val lottoCount = getLottoCount(money)
        val lottoList = getLotto(lottoCount)
        lottoList.forEach { println(it) }
        val winningNum = Input().inputWinningNum()
        val bonusNum = Input().inputBonusNum()

        lottoList.forEach { checkLottoAndWinningNumMatch(it,winningNum,bonusNum) }

        printMatchCount()

    }


    private fun getLottoCount(money: Int): Int = money / 1000

    private fun getLotto(lottoCount: Int): List<List<Int>> {
        println()
        println("${lottoCount}개를 구매했습니다.")
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
            3 -> threeMatch++
            4 -> fourMatch++
            5 -> if (lotto.contains(bonusNumToInt)) fiveBonusMatch++ else fiveMatch++
            6 -> sixMatch++
        }
    }

    private fun printMatchCount() {
        println()
        println("3개 일치 (5,000원) - ${threeMatch}개")
        println("4개 일치 (50,000원) - ${fourMatch}개")
        println("5개 일치 (1,500,000원) - ${fiveMatch}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${fiveBonusMatch}개")
        println("6개 일치 (2,000,000,000원) - ${sixMatch}개")
    }
}

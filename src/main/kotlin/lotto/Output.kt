package lotto

import lotto.constant.OutputMessage
import lotto.domain.LottoSet
import lotto.domain.Winning

object Output {
    fun printLottoCount(lottoCount: Int) {
        println("")
        println(lottoCount.toString() + OutputMessage.MESSAGE_PRINT_LOTTO_COUNT)
    }
    fun printLottoNumber() {

        val lottoSetList = LottoSet.getLottoSet()

        for(i in lottoSetList.indices) {
            println(lottoSetList[i].getNumberPerLotto().joinToString(separator=", ",prefix="[",postfix="]"))
        }
    }

    fun printWinningRate() {
        val winningRateCount = Winning.getWinningRateCount()
        println("")
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - "+winningRateCount[4].toString())
        println("4개 일치 (50,000원) - "+winningRateCount[3].toString())
        println("5개 일치 (1,500,000원) - "+winningRateCount[2].toString())
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winningRateCount[1].toString())
        println("6개 일치 (2,000,000,000원) - "+winningRateCount[0].toString())
    }

    fun printEarningRate(earningRate: Double) {
        println("총 수익률은 " + earningRate.toString() + "%입니다.")
    }
}
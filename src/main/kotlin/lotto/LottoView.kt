package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.util.MessageConstants

class LottoView() {
    fun printError(message: String?) = println(message)
    fun printLottoMoneyRequest() = println(MessageConstants.ENTER_LOTTO_PRICE)
    fun inputLottoMoney(): String = Console.readLine()
    fun printLottoCount(count: Int) = println("\n${count}${MessageConstants.PURCHASED}")
    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.toString())
        }
    }

    fun printWinningNumberRequest() = println(MessageConstants.ENTER_WINNING_NUMBER)
    fun inputWinningNumber(): String = Console.readLine()
    fun printBonusNumberRequest() = println(MessageConstants.ENTER_BONUS_NUMBER)
    fun inputBonusNumber(): String = Console.readLine()
    fun printLottoRankHeader() = println(MessageConstants.RANK_RESULT)
    fun printLottoRank(rank: LottoResult, count: Int) = println(rank.getMessage(count))
    fun printRevenue(revenue: Double) = println("총 수익률은 ${revenue}%입니다.")
}
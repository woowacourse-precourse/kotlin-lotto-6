package lotto

import lotto.model.*

class TestLottoes(private val userNumbers: Set<Int>, private val bonusNumber: Int, paymentAmount: String) :
    Lottoes {

    var lottoes: MutableList<Lotto> = mutableListOf()
    private var lottoesResult: MutableMap<WinningRank, Int> =
        WinningRank.values().associateWith { 0 }.toMutableMap()

    override fun calculateLottoesResult(): Map<WinningRank, Int> {
        TODO("Not yet implemented")
    }

    override fun getTotalProfit(): Profit {
        TODO("Not yet implemented")
    }

}
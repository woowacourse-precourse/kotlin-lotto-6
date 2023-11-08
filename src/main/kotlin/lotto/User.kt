package lotto

import lotto.io.UserInterface

class User(
    private val myLottoTickets: List<Lotto>,
    private val amount: Int
) {
    fun compareToWinningLotto(winningNumber: Lotto, bonusNumber: Int): Map<LottoRank,Int> {
        val myLottoResult = mutableMapOf<LottoRank,Int>()
        for(lotto in LottoRank.values()) {
            myLottoResult[lotto] = 0
        }
        for (myLotto in myLottoTickets) {
            val lottoRank = myLotto.compareToWinningLotto(winningNumber,bonusNumber)
            myLottoResult[lottoRank] = myLottoResult[lottoRank]!! + 1
        }
        return myLottoResult
    }

    fun getAmount(): Int {
        return amount
    }
}
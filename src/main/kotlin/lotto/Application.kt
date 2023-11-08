package lotto

import compareNumber.CompareNumber
import revenue.Revenue
import winningNumber.BonusNumber
import winningNumber.WinningNumber

fun main() {
    val lotto = LottoInitializer()
    val lottos = mutableListOf<Lotto>()
    val winningNumber = WinningNumber()
    val bonusNumber = BonusNumber()
    val compareNumber = CompareNumber()
    val revenue = Revenue()


    val price = lotto.inputPriceOfLotto()
    val amountOfLotto = price / 1000

    for (amount in 0 until amountOfLotto) {
        val numbers = lotto.makeLottoNumber()
        lottos.add(Lotto(numbers))
    }

    for (lotto in 0 until lottos.size) {
        println(lottos[lotto].getNumbers())
    }

    var onlyWinningNumber = winningNumber.inputWinningNumber()
    var addBonusNumber = bonusNumber.inputBonusNumber(onlyWinningNumber)

    var ranks = compareNumber.resultOfLotto(lottos, addBonusNumber)
    compareNumber.showResult(ranks)

    revenue.calculateRateOfRevenue(ranks, price)
}

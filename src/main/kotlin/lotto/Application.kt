package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.PRIZE.*


fun main() {
    var amount = getAmount()

    val lotto = getWinningNumber()

    var bonusNumber = getBonusNumber(lotto)

    val myLottos = getMyLottos(amount / PAYMENT_UNIT)
    printMyLottos(myLottos)

    val result = lotto.getResult(myLottos,bonusNumber)
    printPrize(result)
    printProfit(result,amount)
}


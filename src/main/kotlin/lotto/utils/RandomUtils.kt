package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.ConsoleUtils
class RandomUtils {
    fun lottoNumberCreat(){
        val consoleUtils = ConsoleUtils()
        val purchaseAmount = consoleUtils.inputPurchaseAmountMessage()
        val purchaseCount = purchaseAmount.toDouble()/1000

        repeat(purchaseCount.toInt()){
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println("$numbers")
        }
    }
}
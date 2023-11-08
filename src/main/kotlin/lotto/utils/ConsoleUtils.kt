package lotto.utils

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.Companion.INPUT_PURCHASE_AMOUNT_MESSAGE
class ConsoleUtils {
    //구매 금액 입력
     fun inputPurchaseAmountMessage(): String{
         print(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return Console.readLine()
     }
}
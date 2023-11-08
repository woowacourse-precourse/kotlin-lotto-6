package lotto.utils

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.Companion.INPUT_PURCHASE_AMOUNT_MESSAGE
import lotto.Constants.Companion.OUTPUT_PURCHASE_COUNT_MESSAGE
class ConsoleUtils {
    //구매 금액 입력
     fun inputPurchaseAmountMessage(): String{
         print(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return Console.readLine()
     }

    //구매 갯수 출력
    fun outputPurchaseCountMessage(): String{
        print(OUTPUT_PURCHASE_COUNT_MESSAGE)
        return Console.readLine()
    }

    //당첨 번호 입력


}
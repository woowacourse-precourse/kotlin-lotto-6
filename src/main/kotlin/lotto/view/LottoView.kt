package lotto.view

import lotto.utils.*
class LottoView {
    fun printRequestCost(){
        println(PrintMessage.PRINT_REQUEST_COST)
    }
    fun printRequestWinNumber(){
        println(PrintMessage.PRINT_REQUEST_WIN_NUMBER)
    }
    fun printRequestBonusNumber(){
        println(PrintMessage.PRINT_REQUEST_BONUS_NUMBER)
    }
    fun printTotalResult(){
        println(PrintMessage.PRINT_TOTAL_RESULT)
    }
    fun printTotalArea(){
        println(PrintMessage.PRINT_TOTAL_AREA)
    }
    fun printCount(){
        print(PrintMessage.PRINT_COUNT)
    }
    fun printMatch(){
        print(PrintMessage.PRINT_MATCH)
    }
    fun printTotalRate(){
        print(PrintMessage.PRINT_TOTAL_RATE + " ")
    }
    fun printTotalEndMessage(){
        println(PrintMessage.PRINT_TOTAL_END_MESSAGE)
    }

}

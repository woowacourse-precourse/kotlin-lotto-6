package lotto.view

import lotto.utils.*

class LottoView { // 출력 처리
    fun printRequestCost() {
        println(PrintMessage.PRINT_REQUEST_COST)
    }

    fun printLottoCountCheck(input: Int) {
        println("\n${input}${PrintMessage.PRINT_LOTTO_COUNT_CHECK}")
    }

    fun printLottoAllList(input: List<List<Int>>) {
        for(i in 0 until input.size) {
            println(input.get(i))
        }
    }

    fun printRequestWinNumber() {
        println("\n${PrintMessage.PRINT_REQUEST_WIN_NUMBER}")
    }

    fun printRequestBonusNumber() {
        println("\n${PrintMessage.PRINT_REQUEST_BONUS_NUMBER}")
    }

    fun printTotalResult() {
        println("\n${PrintMessage.PRINT_TOTAL_RESULT}")
    }

    fun printTotalArea() {
        println(PrintMessage.PRINT_TOTAL_AREA)
    }

    fun printCount(input: Int) {
        print("${input}${PrintMessage.PRINT_COUNT_MATCH}")
    }

    fun printTotalRate(input: Double) {
        print("${PrintMessage.PRINT_TOTAL_RATE} ${input}${PrintMessage.PRINT_TOTAL_END_MESSAGE}")
    }

    fun printTotalLottoNumberList(input: MutableList<MutableList<Int>>) {
        for ((index, lotto) in input.withIndex()) {
            println(lotto)
        }
    }



}

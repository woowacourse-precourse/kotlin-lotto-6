package lotto.user

import camp.nextstep.edu.missionutils.Console
import lotto.util.LottoView
import lotto.model.Lotto

enum class PickErrorCode(val message: String){
    NOT_SIZE_NUMBERS("[Error] 당첨 번호가 6개로 주어지지 않았습니다. "),

}
class LottoPick {

    fun pickValid(pickList: List<String>): List<Int> {
        require(pickList.size == 6) {
            throw IllegalArgumentException(PickErrorCode.NOT_SIZE_NUMBERS.message)
        }
        val numbers = pickList.mapNotNull { it.toIntOrNull() }
        Lotto(numbers)
        return numbers
    }
    private fun validPickNumber() : List<Int> {
        val numbers = Console.readLine()
        val pickList = numbers.split(",")
        return pickValid(pickList)
    }
    fun pickNumber(): List<Int> {
        LottoView().pickView()
        while(true) {
            try {
                return validPickNumber()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}
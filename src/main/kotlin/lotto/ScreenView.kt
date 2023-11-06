package lotto

import camp.nextstep.edu.missionutils.Console
class ScreenView {
    private val inputMoneyMessage = "구입금액을 입력해 주세요."
    private val inputLottoMessage = "당첨 번호를 입력해 주세요."
    private val inputBonusNumberMessage = "보너스 번호를 입력해 주세요."

    fun inputMoney(): Int{
        println(inputMoneyMessage)
        val money: Int = Console.readLine().toInt()
        println()
        println("${money/1000}개를 구매했습니다.")
        return money/1000
    }

    fun inputLotto(): List<Int>{
        println(inputLottoMessage)
        val numbers = Console.readLine()?.toString()
        val inputString = numbers?.split(",")
        val inputInt = convertStringsToInts(inputString)
        return inputInt
    }

    fun convertStringsToInts(stringList: List<String>?): List<Int> {
        val intList = mutableListOf<Int>()

        if (stringList != null) {
            for (str in stringList) {
                try {
                    val intValue = str.toInt()
                    intList.add(intValue)
                } catch (e: NumberFormatException) {
                    throw NumberFormatException("정수가 아닙니다.")
                }
            }
        }

        return intList
    }
}
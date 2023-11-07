package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.LottoController

class ScreenView {
    private val inputMoneyMessage = "구입금액을 입력해 주세요."
    private val inputLottoMessage = "당첨 번호를 입력해 주세요."
    private val inputBonusNumberMessage = "보너스 번호를 입력해 주세요."

    fun inputMoney(): Int {
        println(inputMoneyMessage)
        val money: Int = Console.readLine().toInt()
        println()
        println("${money/1000}개를 구매했습니다.")
        return money/1000
    }

    fun inputLotto(): List<Int> {
        println(inputLottoMessage)
        val numbers = Console.readLine()
        println()
        val inputString = numbers?.split(",")?.toMutableList()
        val inputInt = convertStringsToInts(inputString)
        return inputInt.toList()
    }

    fun inputBonusNum(): Int {
        println(inputBonusNumberMessage)
        val bonusNum = Console.readLine().toInt()
        return bonusNum
    }

    fun convertStringsToInts(stringList: MutableList<String>?): MutableList<Int> {
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

    fun printWinningStatistics(result: LottoResult) {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${result.win[0]}개")
        println("4개 일치 (50,000원) - ${result.win[1]}개")
        println("5개 일치 (1,500,000원) - ${result.win[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result.win[3]}개")
        println("6개 일치 (2,000,000,000원) - ${result.win[4]}개")
        println("총 수익률은 ${result.rateOfReturn}%입니다.")
    }
}
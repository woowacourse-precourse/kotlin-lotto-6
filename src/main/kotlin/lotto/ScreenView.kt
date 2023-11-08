package lotto

import camp.nextstep.edu.missionutils.Console

class ScreenView {
    private val inputMoneyMessage = "구입금액을 입력해 주세요."
    private val inputLottoMessage = "당첨 번호를 입력해 주세요."
    private val inputBonusNumberMessage = "보너스 번호를 입력해 주세요."

    fun inputMoney(): Int {
        while (true) {
            try {
                println(inputMoneyMessage)
                val money = Console.readLine().toInt()
                if (money % 1000 != 0) {
                    throw IllegalArgumentException("1000으로 나누어 떨어지는 정수가 아닙니다.")
                }
                println()
                println("${money / 1000}개를 구매했습니다.")
                return money / 1000
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun inputLotto(): List<Int> {
        while (true) {
            try{
                println(inputLottoMessage)
                val numbers = Console.readLine()
                println()
                val inputString = numbers?.split(",")?.toMutableList()
                val inputInt = convertStringsToInts(inputString)
                return inputInt.toList()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun inputBonusNum(): Int {
        while (true) {
            try{
                println(inputBonusNumberMessage)
                val bonusNum = Console.readLine().toInt()
                return bonusNum
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun convertStringsToInts(stringList: MutableList<String>?): MutableList<Int> {
        val intList = mutableListOf<Int>()

        if (stringList != null) {
            for (str in stringList) {
                try {
                    val intValue = str.toInt()
                    intList.add(intValue)
                } catch (e: IllegalArgumentException) {
                    throw IllegalArgumentException("정수가 아닌 것이 포함되어 있습니다.")
                }
            }
        }
        return intList
    }

    fun printWinningStatistics(result: LottoResult) {
        val formattedRateOfReturn = "%.1f".format(result.rateOfReturn)
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${result.win[0]}개")
        println("4개 일치 (50,000원) - ${result.win[1]}개")
        println("5개 일치 (1,500,000원) - ${result.win[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result.win[3]}개")
        println("6개 일치 (2,000,000,000원) - ${result.win[4]}개")
        println("총 수익률은 $formattedRateOfReturn%입니다.")
    }
}
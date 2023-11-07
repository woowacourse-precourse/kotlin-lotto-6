package lotto

// 우선 해당 import 보류 - 오류 발생할 수 있음, 애초에 readmd 조건상에 제외하라고 되어있기는 함
//import java.lang.NumberFormatException
import camp.nextstep.edu.missionutils.Console

class InputValue {

    private val check = CheckError()

    fun inputLottoMoney(): Int {
        val changedMoney: Int

        while (true) {
            val money = Console.readLine()

            if (!check.checkInputPositiveInt(money)) continue
            if (!check.checkCanDivide1000(money.toInt())) continue

            changedMoney = money.toInt()

            break
        }

        return changedMoney
    }

    fun inputWinningNumber(): List<Int> {
        val changedWinningNumber: List<Int>

        while (true) {
            val winningNumber = Console.readLine().split(",")

            if (!check.checkOnlyNumber(winningNumber)) continue
            if (!check.checkNumber1to45(winningNumber)) continue
            if (!check.checkInputSixNumbers(winningNumber)) continue
            if (!check.checkNonOverlapNumber(winningNumber)) continue

            changedWinningNumber = changeStringInt(winningNumber)

            break
        }

        return changedWinningNumber
    }

    fun inputBonusNumber(winning: List<Int>): List<Int> {
        var changedBonusNumber: List<Int>

        while (true) {
            val bonusNumber = Console.readLine().split(",")

            if (!check.checkOnlyNumber(bonusNumber)) continue
            if (!check.checkNumber1to45(bonusNumber)) continue
            if (!check.checkInputOneNumbers(bonusNumber)) continue

            changedBonusNumber = changeStringInt(bonusNumber)

            if (!check.checkNonOverlapBonusNumber(winning, changedBonusNumber[0])) continue

            break
        }

        return listOf(0)
    }

    private fun changeStringInt(numbers: List<String>): List<Int> {
        val changedWinningNumber: MutableList<Int> = mutableListOf()

        for (number in numbers) {
            changedWinningNumber.add(number.toInt())
        }

        return changedWinningNumber
    }

}
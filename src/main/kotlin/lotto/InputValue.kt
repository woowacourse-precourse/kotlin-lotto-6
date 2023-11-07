package lotto

// 우선 해당 import 보류 - 오류 발생할 수 있음, 애초에 readmd 조건상에 제외하라고 되어있기는 함
//import java.lang.NumberFormatException

class InputValue {

    private val check = CheckError()

    fun inputLottoMoney(): Int {

        val moneyInt: Int

        while (true) {

            val money = readln()

            if (!check.checkInputPositiveInt(money)) continue
            if (!check.checkCanDivide1000(money.toInt())) continue

            moneyInt = money.toInt()

            break
        }

        return moneyInt
    }

    fun inputWinningNumber(): List<Int> {

        val winningNumberInt: List<Int>

        while (true) {

            val winningNumber = readln().split(",")

            if (!check.checkOnlyNumber(winningNumber)) continue
            if (!check.checkNumber1to45(winningNumber)) continue
            if (!check.checkInputSixNumbers(winningNumber)) continue
            if (!check.checkNonOverlapNumber(winningNumber)) continue

            winningNumberInt = changeStringInt(winningNumber)

            break
        }

        return winningNumberInt
    }

    fun inputBonusNumber(numbers: List<String>): List<Int> {


        return listOf(0)
    }

    private fun changeStringInt(numbers: List<String>): List<Int> {

        val winningIntNumber: MutableList<Int> = mutableListOf()

        for (number in numbers) {
            winningIntNumber.add(number.toInt())
        }

        return winningIntNumber
    }

}
package lotto

// 우선 해당 import 보류 - 오류 발생할 수 있음, 애초에 readmd 조건상에 제외하라고 되어있기는 함
//import java.lang.NumberFormatException

class InputValue {

    val check = CheckError()

    fun inputLottoMoney(): Int {

        val moneyInt: Int

        while (true) {

            val money = readln()

            if (!check.checkInputPositiveInt(money)) continue
            if (!check.checkCanDivide1000(money.toInt())) continue

            break
        }

        return 0
    }

    fun inputWinningNumber(): List<Int> {

        return listOf(0)
    }

    fun inputBonusNumber(): Int {

        return 0
    }

}
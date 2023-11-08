package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import output.UserInterface

class LottoInitializer {
    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
    }

    fun makeLottoNumber(): List<Int> {
        var lotto = Randoms.pickUniqueNumbersInRange(
            LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
            LOTTO_SIZE
        )
        return lotto.sorted()
    }

    fun inputPriceOfLotto(): Int {
        while (true) {
            println(UserInterface.INPUT_USER_PURCHASE_AMOUNT.mention)
            try {
                var price = Console.readLine().toInt()
                var amount = price / 1000
                checkPriceMultipleOfThousands(price)
                println("$amount" + UserInterface.OUTPUT_USER_PURCHASE_RESULT.mention)
                return price
            } catch (e: NumberFormatException) {
                println(UserInterface.INPUT_NOT_STRING.mention)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


    fun checkPriceMultipleOfThousands(input: Int) {
        if (input % 1000 != 0) throw IllegalArgumentException(UserInterface.INPUT_IN_UNIT_OF_THOUSANDS_EXCEPTION.mention)
    }

}
package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import output.UserInterface

class LottoInitializer {
    companion object{
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
    }

    fun makeLottoNumber(): List<Int>{
        var lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
            LOTTO_SIZE)
        return lotto.sorted()
    }

    fun inputPriceOfLotto(): Int{
        while (true){
            println(UserInterface.INPUT_USER_PURCHASE_AMOUNT.mention)
            try {
                var price = Console.readLine().toInt()
                checkPriceMultipleOfThousands(price)
                return price
            }catch (message: IllegalArgumentException){
                message.printStackTrace()
            }
        }
    }

    fun checkPriceMultipleOfThousands(input: Int){
        if(input % 1000 != 0) throw IllegalArgumentException(UserInterface.INPUT_IN_UNIT_OF_THOUSANDS_EXCEPTION.mention)
    }
}
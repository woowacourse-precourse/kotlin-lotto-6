package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.exception.BonusValidation
import lotto.exception.ErrorConstants
import lotto.exception.LottoValidation
import lotto.exception.PriceValidation

class Input {

    fun inputPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        val price = readLine()
        PriceValidation(price)
        return price.toInt()
    }

    fun inputLottoNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val number = readLine()
        LottoValidation(number)
        return number.split(",").map { it.toInt() }
    }

    fun inputLottoBonusNumber(lotto: List<Int>): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = readLine()
        BonusValidation(lotto, bonusNumber)
        return bonusNumber.toInt()
    }

}
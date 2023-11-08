package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Error

object InputManager {
    private const val SEPARATOR = ","

    fun getPurchaseInput(): Int {
        OutputManager.printInputPurchaseAmount()
        return try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            println(Error.NotNumber.message)
            getPurchaseInput()
        }
    }

    fun getWinningNumber(): List<Int> {
        OutputManager.printInputWinningNum()
        return try {
            Console.readLine()
                .split(SEPARATOR)
                .map { number ->
                    number.trim().toInt()
                }
        } catch (e: NumberFormatException) {
            println(Error.NotNumber.message)
            getWinningNumber()
        }
    }

    fun getBonusNumber(): Int {
        OutputManager.printInputBonusNum()
        return try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            println(Error.NotNumber.message)
            getBonusNumber()
        }
    }
}
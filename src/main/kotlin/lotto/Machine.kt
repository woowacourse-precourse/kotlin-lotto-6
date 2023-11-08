package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.view.ErrorMsg
import lotto.view.Msg
import lotto.view.WinningPrice
import lotto.view.concat
import java.lang.NumberFormatException

class Machine {
    private val price: Int
    private val lottos: MutableList<Lotto> = mutableListOf()
    private var winningNumber: List<Int>
    private val bonusNumber: Int

    init {
        price = getPrice()
        setLottos()
//        당첨 번호 & 보너스 번호 입력
        winningNumber = getNumber()
        bonusNumber = getBonusNumber()
//        최종결과 출력
        calculateResult()
    }

    private fun calculateResult() {
        val result = mutableListOf<WinningPrice>()
        for (lotto in lottos) {
            result.add(lotto.checkLotto(winningNumber, bonusNumber))
        }
        PrintResult(result, price)
    }

    private fun validateNumber(primitiveBonus: String): Boolean {
        return true
    }

    private fun getBonusNumber(): Int {
        println(Msg.INPUT_BONUS_NUMBER.msg)
        val primitiveBonus = Console.readLine()
        if(!validateNumber(primitiveBonus)) {
            printMessage(ErrorMsg.WRONG_NUMBER)
        }

        return primitiveBonus.toInt()
    }

    private fun getNumber(): List<Int> {
        println(Msg.INPUT_WINNING_NUMBER.msg)
        val primitiveWinningNumber: List<String> = Console.readLine().split(",")
        if(!validateWinningNumber(primitiveWinningNumber)) {
            printMessage(ErrorMsg.WRONG_NUMBER)
        }
        val list = mutableListOf<Int>()
        for (i in primitiveWinningNumber) {
            list.add(i.toInt())
        }
        list.sort()
        return list.toList()
    }

    private fun validateWinningNumber(winningNumber: List<String>): Boolean {
        for (number in winningNumber) {
            if(number.isEmpty()) { return false }


        }
        return true
    }

    private fun setLottos() {
        val count: Int = price / 1000
        for (i in 0 until count) {
            lottos.add(LottoCreator.getLotto())
        }
        PrintLotto(count, lottos).showLotto()
    }


    private fun getPrice(): Int {
        while(true) {
            println(Msg.INPUT_PRICE.msg)
            val value = Console.readLine()
            val price = validatePrice(value)
            if(price == 0){ continue }
            return price
        }
    }

    private fun validatePrice(value: String): Int {
        if(value.isEmpty()) { return 0 }
        val price: Int
//    올바른 가격을 입력했는지 검사 & 그에 따른 로또 출력
        try {
            price = value.toInt()
            if (price == (price/1000)*1000) {
                return price
            }
            printMessage(ErrorMsg.WRONG_PRICE)
            return 0
        } catch (e: NumberFormatException) {
            printMessage(ErrorMsg.STRING_PIRCE)
            return 0
        }
    }

    private fun printMessage(str: ErrorMsg) {
        val msg: String = concat(ErrorMsg.ERROR, str)
        println(msg)
        IllegalArgumentException(msg)
    }
}

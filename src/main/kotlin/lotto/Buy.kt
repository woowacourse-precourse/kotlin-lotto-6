package lotto

import camp.nextstep.edu.missionutils.Randoms
import exception.Exception
import exception.Message
import ui.Input.inputMoney
import ui.Output

class Buy {
    init {
        println(Message.MESSAGE_INPUT_MONEY)
    }
    fun buyLotto(): Int {
        val inputMoney = inputMoney()
        return inputMoney / 1000
    }

    fun validateMoney(money: String) {
        if (money.toInt() % 1000 != 0) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_MONEY)
        }
        if (!money.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_MONEY_TYPE)
        }
    }

    fun generateLottos(count: Int): Lottos{
        val lottos = Lottos()
        for (i in 1..count) {
            val lotto = Lotto(createWinningLotto())
            lottos.addUserLotto(lotto)
        }
        return lottos
    }

    fun createWinningLotto(): MutableList<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}
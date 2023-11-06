package lotto

import camp.nextstep.edu.missionutils.Randoms
import exception.Exception
import exception.Message
import ui.Input


class Buy {
    init {
        println(Message.MESSAGE_INPUT_MONEY)
    }

    fun buyLotto(): Int {
        try {
            val money = Input.inputMoney()
            validateMoney(money.toString())
            return money / 1000
        } catch (e: IllegalArgumentException) {
            println(Exception.EXCEPTION_INVALID_MONEY_TYPE)
            return buyLotto()
        } catch (e: NumberFormatException) {
            println(Exception.EXCEPTION_INVALID_MONEY)
            return buyLotto()
        }
    }

    fun validateMoney(money: String) {
        if (!money.matches(Regex("[0-9]+"))) {
            throw NumberFormatException()
        }
        if (money.toInt() % 1000 != 0) {
            throw IllegalArgumentException()
        }
    }

    fun generateLottos(count: Int): Lottos {
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

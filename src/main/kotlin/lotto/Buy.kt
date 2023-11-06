package lotto

import camp.nextstep.edu.missionutils.Randoms
import exception.Exception
import exception.Message
import ui.Input


class Buy {
    fun buyLotto(): Int {
        var inputMoney: Int
        while (true) {
            println(Message.MESSAGE_INPUT_MONEY)
            try {
                inputMoney = Input.inputMoney()
                if (inputMoney % 1000 != 0) {
                    println(Exception.EXCEPTION_INVALID_MONEY)
                    throw IllegalArgumentException()
                }
                if (!inputMoney.toString().trim().all { Character.isDigit(it) }) {
                    println(Exception.EXCEPTION_INVALID_MONEY_TYPE)
                    throw IllegalArgumentException()
                }
                break
            } catch (e: IllegalArgumentException) {

            }
        }
        return inputMoney / 1000
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
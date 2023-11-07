package lotto

import camp.nextstep.edu.missionutils.Randoms
import exception.Message
import ui.Input


class Buy {
    init {
        println(Message.MESSAGE_INPUT_MONEY)
    }

    fun buyLotto(): Int {
        try {
            val moneyStr = Input.inputMoney().toString()
            val money = moneyStr.toInt()

            if (money % 1000 == 0) {
                return money / 1000
            }
            println("[ERROR] 로또 구입 금액은 1000의 배수여야 합니다.")
            return buyLotto()
        } catch (e: NumberFormatException) {
            println("[ERROR] 로또 구입 금액은 숫자로만 가능합니다.")
            return buyLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return buyLotto()
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
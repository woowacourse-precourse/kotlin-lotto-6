package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constant.Companion.LOTTO_SIZE
import lotto.constants.Constant.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.constants.Constant.Companion.MINIMUM_LOTTO_NUMBER
import lotto.constants.Constant.Companion.MONEY_UNIT
import lotto.constants.Constant.Companion.START_INDEX
import lotto.constants.Exception.Companion.EXCEPTION_INVALID_CHARACTER
import lotto.constants.Exception.Companion.EXCEPTION_INVALID_MONEY
import lotto.views.InputView.inputMoney
import lotto.views.OutputView
import lotto.views.OutputView.printInputMoney

class Purchase {
    init {
        printInputMoney()
    }

    fun buyLotto(): Int {
        val money = inputMoney()
        validateMoney(money)
        return money.toInt() / MONEY_UNIT
    }

    fun validateMoney(money: String) {
        if (!money.all { Character.isDigit(it) }) {
            OutputView.printExceptionMessage(EXCEPTION_INVALID_CHARACTER)
            throw IllegalArgumentException(EXCEPTION_INVALID_CHARACTER)
        }
        if (money.toInt() % MONEY_UNIT != 0) {
            OutputView.printExceptionMessage(EXCEPTION_INVALID_MONEY)
            throw IllegalArgumentException(EXCEPTION_INVALID_MONEY)
        }
    }

    // 구매 수량 만큼의 로또를 생성하여 리스트로 반환하는 메소드
    fun createLottos(amount: Int): LottoWrapper {
        val lottos = LottoWrapper()
        for (i in START_INDEX until amount) {
            val lotto = Lotto(createLottoNumber().sorted())
            lottos.add(lotto)
        }
        return lottos
    }

    private fun createLottoNumber(): MutableList<Int> {
        return Randoms.pickUniqueNumbersInRange(
            MINIMUM_LOTTO_NUMBER,
            MAXIMUM_LOTTO_NUMBER,
            LOTTO_SIZE
        )
    }
}
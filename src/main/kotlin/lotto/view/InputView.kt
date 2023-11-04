package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.utils.Exceptions.inputPurchaseAmountException
import lotto.utils.Exceptions.inputWinningNumberException


class InputView {

    fun inputPurchaseAmount(): Int {
        while (true) {
            inputPurchaseAmountException(Console.readLine().trim())
                .onSuccess { return it }
                .onFailure { println(it) }
        }
    }

    fun inputWinningNumber(): Lotto {
        while (true) {
            inputWinningNumberException(Console.readLine().trim().split(","))
                .onSuccess { return it }
                .onFailure { println(it) }
        }
    }

}
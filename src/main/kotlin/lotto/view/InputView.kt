package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Exceptions.inputPurchaseAmountException


class InputView {

    fun inputPurchaseAmount(): Int {
        while (true) {
            inputPurchaseAmountException(Console.readLine().trim())
                .onSuccess { return it }
                .onFailure { println(it) }
        }
    }

}
package lotto.view

import lotto.constant.Constant.BUY_NUMBER_MESSAGE

class OutputView {
    fun buyNumberMessage(buyNumber: Int) = println(buyNumber + BUY_NUMBER_MESSAGE)
}
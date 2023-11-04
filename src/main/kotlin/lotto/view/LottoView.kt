package lotto.view

import lotto.util.InputUtil
import lotto.util.OutputUtil

class LottoView {
    fun showBuyViewAndReturnMoney(): Int {
        OutputUtil.printInputMoney()
        return InputUtil.inputMoney()
    }
}
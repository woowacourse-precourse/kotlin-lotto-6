package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    private val view = View()

    fun start() {
        val payment = view.printInputPaymentMessage()
    }

    private fun countLotto(payment: Int): Int {
        return payment / 1000
    }

}
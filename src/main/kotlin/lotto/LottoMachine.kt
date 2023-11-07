package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    private val view = View()

    fun start() {
        val payment = view.printInputPaymentMessage()
        val lottos = makeLotto(payment)
        view.printLotto(lottos)
        val inputLottoNumber = view.printInputLottoNumber()
    }

    private fun makeLotto(payment: Int): List<Lotto> {
        val count = countLotto(payment)
        val lotto = mutableListOf<Lotto>()
        repeat(count) {
            lotto.add(generateLotto())
        }
        return lotto
    }

    private fun generateLotto(): Lotto {
        val num = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(num.sorted())
    }

    private fun countLotto(payment: Int): Int {
        return payment / 1000
    }
}
package lotto.domain

import lotto.model.Lotto
import lotto.util.Const

class LottoMaker() {

    fun makeLottoTickets(amount: Int): List<Lotto> {

        val times = amount / Const.DOLLAR
        val myTickets = mutableListOf<Lotto>()
        val generator = RandomNumbersGenerator()

        repeat(times) {
            val numbers = generator.makeRandomNumbers()
            myTickets.add(Lotto(numbers))
        }
        return myTickets
    }
}
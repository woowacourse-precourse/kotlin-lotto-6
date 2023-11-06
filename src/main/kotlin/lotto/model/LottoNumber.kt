package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoNumber {
    fun generateLotto(number: Int): MutableList<Lotto> {
        var lotteryTickets = mutableListOf<Lotto>()
        for (index in 0 until number) {
            var randomLottoNumber = generateRandomNumber()
            lotteryTickets.add(Lotto(randomLottoNumber.sorted()))
        }
        return lotteryTickets
    }

    fun generateRandomNumber() = Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
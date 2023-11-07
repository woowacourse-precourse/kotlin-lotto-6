package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoRepository {
    fun generateAutoLottoTickets(lottoTicketsNum: Int): List<Lotto> {
        val tickets = buildList<Lotto>(lottoTicketsNum) {
            repeat(lottoTicketsNum){
                generateLotto()
            }
        }
        return tickets
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).toList().sorted()
        return Lotto(numbers)
    }

    fun calculateLottoTickets(
        generatedAutoLottoTickets: List<Lotto>,
        winningLottoInfo: Lotto,
        bonusInfo: Int
    ): Pair<List<Int>, Double> {

    }
}

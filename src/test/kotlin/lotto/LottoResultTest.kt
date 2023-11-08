package lotto

import lotto.model.Lotto
import lotto.model.LottoResult
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `로또 당첨결과를 올바르게 계산해야 한다`(){
        val lottoResult = LottoResult()
        val lottoTicketsNum = 6
        val autoLottoTickets = listOf(
            Lotto(listOf(1,2,3,4,5,6)),
            Lotto(listOf(2,3,4,5,6,7)),
            Lotto(listOf(3,4,5,6,7,8)),
            Lotto(listOf(4,5,6,7,8,9)),
            Lotto(listOf(5,6,7,8,9,10)),
            Lotto(listOf(6,7,8,9,10,11)))
        val winningLottoInfo = Lotto(listOf(5,6,7,20,30,40))
        val value = lottoResult.calculateLottoResult(lottoTicketsNum, autoLottoTickets, winningLottoInfo, 45)
        val ranks = listOf(0, 0, 0, 0, 0, 4)
        val rate = "333.33"
        println(ranks)
        assert(value.first == ranks && value.second == rate)
    }


}
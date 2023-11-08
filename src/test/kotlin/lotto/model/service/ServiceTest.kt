package lotto.model.service

import lotto.model.domain.Lotto
import lotto.model.domain.Rank
import lotto.model.domain.WinningLotto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

val service = Service()

class ServiceTest {
    @Test
    @DisplayName("로또 등수 반환 테스트")
    fun compareLottoTest() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(lotto, 9)
        val rank: Rank = service.compareLotto(winningLotto, lotto)
        assert(rank == Rank.FIRST)
    }
}
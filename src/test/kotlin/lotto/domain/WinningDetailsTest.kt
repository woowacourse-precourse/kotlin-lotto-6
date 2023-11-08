package lotto.domain

import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoWallet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class WinningDetailsTest {

    @Test
    fun `해당 클래스를 출력했을 때 올바른 형식의 당첨 통계를 출력해야 한다`() {
        assertDoesNotThrow {
            val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
            val lottoWallet = LottoWallet(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    Lotto(listOf(1, 2, 3, 7, 8, 9)),
                )
            )
            assertThat (
                WinningDetails(winningLotto, lottoWallet).toString()
            ).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개",
            )
        }
    }

}
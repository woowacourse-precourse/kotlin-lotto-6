package lotto.utils

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import lotto.data.model.LottoWinningNumber
import lotto.data.model.UserLottoState
import lotto.utils.GameUtils
import lotto.utils.PrizeType
import org.junit.jupiter.api.Assertions.assertEquals

class GameUtilsTest {

    @Test
    fun `testParseToInt 메서드로 문자열 파싱 확인`() {

        val numString = "1, 2, 3, 4, 5, 6"
        val result = GameUtils.parseToInt(numString)

        val expected = listOf(1, 2, 3, 4, 5, 6)
        assertEquals(expected, result, "parseToInt 결과가 일치하지 않습니다.")
    }

    @Test
    fun `totalStatistics 메서드로 최종 통계 계산`() {

        val lottoState = UserLottoState(emptyList())
        val winningNumber = LottoWinningNumber(lottoNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val lottoTicket1 = listOf(1, 2, 3, 4, 5, 6) // 1등
        val lottoTicket2 = listOf(1, 2, 3, 4, 5, 7) // 2등
        val lottoTicket3 = listOf(1, 2, 3, 4, 7, 8) // 4등
        val lottoTicket4 = listOf(1, 2, 3, 7, 8, 9) // 5등
        val lottoTicket5 = listOf(1, 2, 7, 8, 9, 10) // NONE

        lottoState.lottoTickets = listOf(lottoTicket1, lottoTicket2, lottoTicket3, lottoTicket4, lottoTicket5)

        val updatedLottoState = GameUtils.totalStatistics(lottoState, winningNumber)

        assertThat(updatedLottoState.firstPrizeCount).isEqualTo(1)
        assertThat(updatedLottoState.secondPrizeCount).isEqualTo(1)
        assertThat(updatedLottoState.thirdPrizeCount).isEqualTo(0)
        assertThat(updatedLottoState.fourthPrizeCount).isEqualTo(1)
        assertThat(updatedLottoState.fifthPrizeCount).isEqualTo(1)
    }

    @Test
    fun `calculateTotalPrizeRate 메서드로 총 상금 비율 계산`() {

        val lottoState = UserLottoState(emptyList())
        lottoState.firstPrizeCount = 1
        lottoState.secondPrizeCount = 2
        lottoState.thirdPrizeCount = 3
        lottoState.fourthPrizeCount = 4
        lottoState.fifthPrizeCount = 5
        lottoState.lottoTickets = listOf(listOf(1, 2, 3, 4, 5, 6))

        val updatedLottoState = GameUtils.calculateTotalPrizeRate(lottoState)

        assertThat(updatedLottoState.totalPrizeAmount).isEqualTo(
            PrizeType.FIRST.price * 1 +
                    PrizeType.SECOND.price * 2 +
                    PrizeType.THIRD.price * 3 +
                    PrizeType.FOURTH.price * 4 +
                    PrizeType.FIFTH.price * 5
        )

        assertThat(updatedLottoState.totalPrizeRate).isEqualTo(
            (updatedLottoState.totalPrizeAmount.toDouble() / lottoState.lottoTickets.size / 1000).times(100.0)
        )

    }

    @Test
    fun `generateLotto 메서드로 로또 번호 생성`() {
        val count = 5

        val lottoNumbersList = GameUtils.generateLotto(count)

        assertThat(lottoNumbersList).hasSize(count)
        assertThat(lottoNumbersList).allMatch { it.size == 6 }
        assertThat(lottoNumbersList).allMatch { it.all { num -> num in 1..45 } }
    }
}

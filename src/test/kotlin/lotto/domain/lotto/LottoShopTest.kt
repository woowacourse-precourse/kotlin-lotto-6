package lotto.domain.lotto

import lotto.domain.Money
import lotto.domain.winningResult.MatchCount
import lotto.domain.winningResult.RateOfReturn
import lotto.domain.winningResult.WinningRank
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `로또 구매 - 정상 입력`() {
        // given
        val input = Money(5000)
        // when
        val result = LottoShop.purchaseLottos(input)
        // then
        assertEquals(5, result.size())
    }

    @Test
    fun `로또 구매 - 1,000으로 나뉘어 지지 않는 값 예외 처리`() {
        // given
        val input = Money(1001)
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoShop.purchaseLottos(input) }
            .withMessage("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.")
    }

    @Test
    fun `로또 구매 - 1,000 미만 값 예외 처리`() {
        // given
        val input = Money(500)
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoShop.purchaseLottos(input) }
            .withMessage("[ERROR] 구입금액은 최소 1,000원 이상 입력해야 합니다.")
    }

    @Test
    fun `로또 당첨 결과 확인`() {
        // given
        val winningLotto = WinningLotto(
            winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
            bonusNumber = LottoNumber(7)
        )
        val purchasedLottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                Lotto(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }),
                Lotto(listOf(1, 2, 3, 4, 5, 45).map { LottoNumber(it) }),
                Lotto(listOf(1, 2, 3, 4, 44, 45).map { LottoNumber(it) }),
                Lotto(listOf(1, 2, 3, 43, 44, 45).map { LottoNumber(it) })
            )
        )
        // when
        val result = LottoShop.getWinningResult(winningLotto, purchasedLottos)
        // then
        val winningResult = result.result
        val rateOfReturn = result.rateOfReturn
        assertEquals("1개", winningResult[WinningRank.FIRST].toString())
        assertEquals("1개", winningResult[WinningRank.SECOND].toString())
        assertEquals("1개", winningResult[WinningRank.THIRD].toString())
        assertEquals("1개", winningResult[WinningRank.FOURTH].toString())
        assertEquals("1개", winningResult[WinningRank.FIFTH].toString())
        assertEquals("40631100.0%", rateOfReturn.toString())
    }
}
package lotto

import lotto.constants.Exception
import lotto.constants.WinningRank
import lotto.model.PurchaseInfo
import lotto.model.WinningAmount
import lotto.model.lotto.Bonus
import lotto.model.lotto.Lotto
import lotto.model.lotto.PurchaseLottos
import lotto.model.lotto.WinningLotto
import lotto.service.LottoSupplier
import lotto.service.WinningCalculator
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    private val calculator = WinningCalculator()

    @Nested
    inner class LottoExceptionTest {
        @Test
        fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
            }
        }

        @Test
        fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 5))
            }
        }

        @Test
        fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
            assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5)) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.LOTTO_SIZE.toString())
        }

        @Test
        fun `로또 번호가 정렬되어 있지 않으면 예외가 발생한다`() {
            assertThatThrownBy { Lotto(listOf(1, 2, 4, 3, 5, 6)) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.LOTTO_SORT.toString())
        }

        @Test
        fun `로또 번호가 범위 1~45를 벗어나면 예외가 발생한다`() {
            assertThatThrownBy { Lotto(listOf(1, 3, 5, 35, 60, 90)) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.LOTTO_RANGE.toString())
        }

        @Test
        fun `로또 번호가 조건을 만족하면 예외가 발생하지 않는다`() {
            assertThatCode { Lotto(listOf(1, 3, 5, 10, 15, 42)) }
                .doesNotThrowAnyException()
        }

        @Test
        fun `구매 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다`() {
            assertThatThrownBy { PurchaseInfo(1200) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.PURCHASE_DIVISIBLE.toString())
        }

        @ParameterizedTest
        @ValueSource(ints = [1000000, 110000, 98765000])
        fun `로또 최대 구매 개수보다 많은 로또를 구매할 수 있으면 예외가 발생한다`(구매금액: Int) {
            assertThatThrownBy { PurchaseInfo(구매금액) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.PURCHASE_MAX_COUNT.toString())
        }

        @Test
        fun `구매 금액이 조건을 만족하면 예외가 발생하지 않는다`() {
            val 구매금액 = 8000

            assertThatCode {
                PurchaseInfo(구매금액)
            }
                .doesNotThrowAnyException()
        }

        @Test
        fun `보너스 번호가 범위 1~45를 벗어나면 예외가 발생한다`() {
            assertThatThrownBy { Bonus(50) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.LOTTO_RANGE.toString())
        }

        @Test
        fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
            // given
            val 당첨번호 = Lotto(listOf(3, 5, 10, 28, 30, 42))
            val 보너스번호 = Bonus(30)

            // when, then
            assertThatThrownBy { WinningLotto(당첨번호, 보너스번호) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.LOTTO_DUPLICATION.toString())
        }
    }

    @Test
    fun `인자로 주어진 로또 개수만큼 로또를 발행한다`() {
        // given
        val 로또개수 = 10

        // when
        val result = LottoSupplier().supplyPurchaseLottos(로또개수)

        // then
        assertThat(result).isInstanceOf(PurchaseLottos::class.java)

        var 실제생성된개수 = 0
        result.forEach { 실제생성된개수++ }
        assertThat(실제생성된개수).isEqualTo(로또개수)
    }

    @ParameterizedTest
    @MethodSource("테스트데이터_로또번호_일치개수")
    fun `일치하는 로또 번호의 개수를 카운트한다`(비교할로또번호: List<Int>, 기댓값: Int) {
        // given
        val 로또번호 = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val 결과 = 로또번호.countMatchingNumber(Lotto(비교할로또번호))

        // then
        assertThat(결과).isEqualTo(기댓값)
    }

    @ParameterizedTest
    @MethodSource("테스트데이터_보너스_일치여부")
    fun `보너스 번호가 일치한지 판별한다`(보너스번호: Int, 기댓값: Boolean) {
        // given
        val 로또번호 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val 보너스 = Bonus(보너스번호)

        // when
        val 결과 = 로또번호.isMatchingBonus(보너스)

        // then
        assertThat(결과).isEqualTo(기댓값)
    }

    @ParameterizedTest
    @MethodSource("테스트데이터_당첨결과_계산")
    fun `로또 당첨 결과를 계산한다`(구매로또_리스트: List<Lotto>, 당첨로또번호: List<Int>, 보너스: Int) {
        // given
        val 구매한로또 = PurchaseLottos(구매로또_리스트)
        val 당첨로또 = WinningLotto(Lotto(당첨로또번호), Bonus(보너스))

        // when
        val 결과 = calculator.calculateWinningResult(구매한로또, 당첨로또)

        // then
        val 당첨횟수_기댓값 = listOf(
            WinningRank.FIRST to 1,
            WinningRank.SECOND to 1,
            WinningRank.THIRD to 0,
            WinningRank.FOURTH to 0,
            WinningRank.FIFTH to 1
        )

        당첨횟수_기댓값.forEach { expected ->
            assertThat(결과.winningCounts[expected.first]).isEqualTo(expected.second)
        }

        val 당첨금액_기댓값: Int =
            WinningRank.FIRST.amount + WinningRank.SECOND.amount + WinningRank.FIFTH.amount

        assertThat(결과.winningAmount.amount).isEqualTo(당첨금액_기댓값.toLong())
    }

    @ParameterizedTest
    @MethodSource("테스트데이터_총수익률_계산")
    fun `로또 총 수익률을 계산한다`(추가할_당첨금액: Int, 구매금액: Int, 기댓값: Double) {
        // given
        val 당첨금액 = WinningAmount()
        당첨금액.add(추가할_당첨금액)

        // when
        val 결과 = calculator.calculateTotalReturn(당첨금액, 구매금액)

        // then
        assertThat(결과).isEqualTo(기댓값)
    }

    companion object {
        @JvmStatic
        fun `테스트데이터_로또번호_일치개수`() = listOf(
            Arguments.of(listOf(1, 2, 3, 10, 11, 12), 3),
            Arguments.of(listOf(10, 15, 23, 28, 34, 40), 0),
            Arguments.of(listOf(5, 6, 25, 31, 40, 42), 2)
        )

        @JvmStatic
        fun `테스트데이터_보너스_일치여부`() = listOf(
            Arguments.of(1, true),
            Arguments.of(3, true),
            Arguments.of(5, true),
            Arguments.of(10, false),
            Arguments.of(20, false),
            Arguments.of(30, false),
        )

        @JvmStatic
        fun `테스트데이터_당첨결과_계산`() = listOf(
            Arguments.of(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 3, 4, 5, 11)),
                    Lotto(listOf(10, 20, 22, 25, 30, 42)),
                    Lotto(listOf(1, 2, 3, 10, 13, 20))
                ),
                listOf(1, 2, 3, 4, 5, 6),
                11
            )
        )

        @JvmStatic
        fun `테스트데이터_총수익률_계산`() = listOf(
            Arguments.of(5000, 8000, 62.5),
            Arguments.of(2000000000, 1000, 200000000.0),
            Arguments.of(3150000, 5000, 63000.0),
            Arguments.of(5000, 5000, 100.0),
        )
    }
}

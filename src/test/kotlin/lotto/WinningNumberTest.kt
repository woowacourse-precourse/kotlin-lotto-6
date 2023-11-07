package lotto

import lotto.model.Lotto
import lotto.model.Winning
import lotto.model.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningNumberTest {
    @Test
    fun `당첨 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                normalNumbers = listOf(1, 2, 3, 4, 5, 5),
                bonusNumber = 7
            )
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                normalNumbers = listOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 1
            )
        }
    }

    @Test
    fun `당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                normalNumbers = listOf(1, 2, 3, 4, 5, 6, 7),
                bonusNumber = 1
            )
        }
    }

    @Test
    fun `당첨 번호의 개수가 6개보다 작으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                normalNumbers = listOf(1, 2, 3, 4, 5),
                bonusNumber = 1
            )
        }
    }

    @Test
    fun `당첨 번호 숫자가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                normalNumbers = listOf(1, 2, 3, 4, 5, 46),
                bonusNumber = 1
            )
        }
    }

    @Test
    fun `보너스 번호 숫자가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(
                normalNumbers = listOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 46
            )
        }
    }

    @ParameterizedTest
    @MethodSource("generate_WinningNumber_Lotto_Winning")
    fun `로또 번호와 비교하면 당첨 결과가 반환된다`(
        winningNumber: WinningNumber,
        lotto: Lotto,
        expected: Winning
    ) {
        val actual = winningNumber.check(lotto)
        assert(actual == expected) {
            "Actual: $actual, Expected: $expected"
        }
    }

    companion object {
        @JvmStatic
        fun generate_WinningNumber_Lotto_Winning(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    WinningNumber(normalNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Winning.Six
                ),
                Arguments.of(
                    WinningNumber(normalNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7),
                    Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    Winning.Six
                ),
                Arguments.of(
                    WinningNumber(normalNumbers = listOf(1, 2, 3, 4, 10, 11), bonusNumber = 5),
                    Lotto(listOf(1, 2, 3, 4, 5, 45)),
                    Winning.FiveAndBonus
                ),
                Arguments.of(
                    WinningNumber(normalNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7),
                    Lotto(listOf(1, 2, 3, 4, 5, 45)),
                    Winning.Five
                ),
                Arguments.of(
                    WinningNumber(normalNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7),
                    Lotto(listOf(1, 2, 3, 7, 15, 45)),
                    Winning.Four
                ),
                Arguments.of(
                    WinningNumber(normalNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7),
                    Lotto(listOf(10, 20, 30, 40, 41, 45)),
                    Winning.None
                )
            )
        }
    }
}

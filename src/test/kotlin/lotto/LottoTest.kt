package lotto

import lotto.domain.LottoRank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class LottoTest {
    private lateinit var lotto: Lotto

    companion object {
        @JvmStatic
        fun invalidLottos(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(0, 1, 2, 3, 4, 5)),
                Arguments.of(listOf(-10, 1, 2, 3, 4, 5)),
                Arguments.of(listOf(62, 1, 2, 3, 4, 5))
            )
        }

        @JvmStatic
        fun winningNumberSet(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Pair(listOf(1, 2, 3, 4, 5, 6), 45), 6, false),
                Arguments.of(Pair(listOf(1, 2, 3, 4, 5, 7), 6), 5, true),
                Arguments.of(Pair(listOf(1, 2, 3, 4, 5, 7), 45), 5, false),
                Arguments.of(Pair(listOf(11, 2, 3, 4, 5, 15), 45), 4, false),
                Arguments.of(Pair(listOf(1, 2, 3, 14, 15, 17), 45), 3, false)
            )
        }
    }

    @BeforeEach
    fun setUp() {
        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @MethodSource("invalidLottos")
    fun `로또 번호가 1 ~ 45 범위를 벗어난 숫자가 있으면 예외가 발생한다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("winningNumberSet")
    fun `구매한 로또와 당첨 번호들과 보너스 번호를 비교기능 테스트`(
        winningNumberSet: Pair<List<Int>, Int>,
        expectedMatchNumber: Int,
        expectedMatchBonus: Boolean
    ) {
        val result = lotto.compareNumber(winningNumberSet)

        assertEquals(expectedMatchNumber, result.first)
        assertEquals(expectedMatchBonus, result.second)
    }

    @ParameterizedTest
    @CsvSource(
        "0, false, OUT_OF_RANK",
        "0, true, OUT_OF_RANK",
        "1, false, OUT_OF_RANK",
        "1, true, OUT_OF_RANK",
        "2, false, OUT_OF_RANK",
        "2, true, OUT_OF_RANK",
        "3, false, FIFTH_PLACE",
        "3, true, FIFTH_PLACE",
        "4, false, FOURTH_PLACE",
        "4, true, FOURTH_PLACE",
        "5, false, THIRD_PLACE",
        "5, true, SECOND_PLACE",
        "6, false, FIRST_PLACE"
    )
    fun `로또 당첨 결과 판별기능 테스트`(
        matchNumbers: Int,
        matchBonus: Boolean,
        expectedRank: LottoRank
    ) {
        val compareResult = Pair(matchNumbers, matchBonus)
        val result = lotto.resultOfLotto(compareResult)
        assertEquals(expectedRank, result)
    }
}

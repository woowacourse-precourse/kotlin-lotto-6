package lotto.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningRecordTest {
    private lateinit var winningRecord: WinningRecord

    @BeforeEach
    fun setUp() {
        winningRecord = WinningRecord()
    }

    @ParameterizedTest
    @MethodSource("generateMatchingNumbersTestCases")
    fun `구매 로또와 당첨 로또의 번호들을 비교해 일치하는 개수를 계산하는 테스트`(
        purchasedLotto: Lotto,
        winningLotto: Lotto,
        expectedMatchedCount: Int,
    ) {
        val actualMatchedCount = winningRecord.calculateMatchingNumbers(purchasedLotto, winningLotto)

        assertThat(actualMatchedCount).isEqualTo(expectedMatchedCount)
    }

    @Test
    fun `구매 로또 번호 중 일치하는 보너스 번호가 있으면 참이다`() {
        val bonus = Bonus(1)
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expectedResult = true

        val actualResult = winningRecord.hasMatchingBonusNumber(winningLotto, bonus)

        assertThat(actualResult).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun generateMatchingNumbersTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    6
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    5
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 3, 4, 7, 8)),
                    4
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 3, 7, 8, 9)),
                    3
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 7, 8, 9, 10)),
                    2
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 7, 8, 9, 10, 11)),
                    1
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(7, 8, 9, 10, 11, 12)),
                    0
                )
            )
        }
    }
}
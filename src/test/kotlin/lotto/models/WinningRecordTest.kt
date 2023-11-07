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

    companion object {
        @JvmStatic
        fun generateMatchingNumbersTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    -1
                )
            )
        }
    }
}
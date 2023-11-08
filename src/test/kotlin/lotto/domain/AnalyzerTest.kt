package lotto.domain

import lotto.data.Lotto
import lotto.data.Stats
import lotto.data.WinningInfo
import lotto.data.WinningLotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class AnalyzerTest {

    private lateinit var calculator: Calculator
    private lateinit var analyzer: Analyzer

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
        analyzer = Analyzer(calculator)
    }

    @ParameterizedTest
    @MethodSource("generateForGetStats")
    @DisplayName("Analyzer : getStats()")
    fun `구입한 로또와 당첨 번호를 비교해서 통계를 반환한다`(data: Triple<List<Lotto>, WinningLotto, Stats>) {
        // given
        val (tickets, winningLotto, expected) = data

        // when
        val actual = analyzer.getStats(tickets, winningLotto)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun generateForGetStats(): List<Triple<List<Lotto>, WinningLotto, Stats>> {
            return listOf(
                Triple(
                    listOf(
                        Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    ),
                    WinningLotto(listOf(1, 2, 3, 4, 8, 45), 30),
                    Stats(
                        WinningInfo(0, 0, 0, 2, 0),
                        50.0
                    )
                ),
                Triple(
                    listOf(
                        Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    ),
                    WinningLotto(listOf(1, 2, 8, 9, 10, 45), 4),
                    Stats(
                        WinningInfo(0, 0, 0, 0, 0),
                        0.0
                    )
                ),
                Triple(
                    listOf(
                        Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(listOf(7, 8, 9, 10, 11, 12)),
                    ),
                    WinningLotto(listOf(7, 8, 9, 10, 11, 13), 12),
                    Stats(
                        WinningInfo(0, 1, 0, 0, 0),
                        15_000.0
                    )
                ),
            )
        }
    }
}
package lottonumbercomparator

import lotto.Lotto
import lottoranking.LottoRanking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import winningnumber.WinningNumber
import java.util.*
import java.util.stream.Stream

class LottoNumberComparatorTest {
    private lateinit var lottoNumberComparator: LottoNumberComparator

    @BeforeEach
    fun setUp() {
        lottoNumberComparator = LottoNumberComparatorImpl()
        LottoRanking.entries.forEach { it.count = 0 }
    }

    @ParameterizedTest
    @MethodSource("generateData")
    fun `각 등수 당첨됐을 때 각 등수 갯수가 오르는지 확인`(
        winningNumber: List<Int>,
        bonusNumber: Int,
        lotto: List<Int>,
        lottoRanking: LottoRanking,
        output: Int,
    ) {
        lottoNumberComparator.compare(WinningNumber(winningNumber, bonusNumber), Lotto(lotto))

        assertThat(lottoRanking.count).isEqualTo(output)
    }

    companion object {
        @JvmStatic
        fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 6), LottoRanking.FIRST, 1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 7), LottoRanking.SECOND, 1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 45), LottoRanking.THIRD, 1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 44, 45), LottoRanking.FOURTH, 1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 43, 44, 45), LottoRanking.FIFTH, 1),
            )
        }
    }
}
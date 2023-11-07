package lotto

import lotto.model.Lotto
import lotto.model.WinningRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class LottoTest {
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

    // 아래에 추가 테스트 작성 가능
    @ParameterizedTest
    @MethodSource("provideInvalidElementAmount")
    fun `로또 번호가 6 개가 아니면 예외를 던진다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("provideDuplicatedElement")
    fun `로또 번호에 중복된 숫자가 있으면 예외를 던진다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidRangeElement")
    fun `로또 번호가 1~45 범위가 아닌 숫자가 있으면 예외를 던진다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("provideNormalElement")
    fun `정상적인 로또 번호를 입력했을 경우 정상 동작한다`(numbers: List<Int>) {
        assertDoesNotThrow {
            Lotto(numbers)
        }
    }


    @ParameterizedTest
    @MethodSource("provideLottoTestData")
    fun `input 번호와 로또 번호 중 같은 숫자의 개수를 센다`(lottoTestData: LottoTestData) {
        val result = lottoTestData.lotto.calculateMatchingCount(lottoTestData.inputNumbers)
        assertThat(result).isEqualTo(lottoTestData.matchingCount)
    }

    @ParameterizedTest
    @MethodSource("provideLottoTestData")
    fun `보너스 번호가 로또 번호 중 일치하는 것이 있는지 판단한다`(lottoTestData: LottoTestData) {
        val result = lottoTestData.lotto.containBonusNumber(lottoTestData.bonusNumber)
        assertThat(result).isEqualTo(lottoTestData.containBonusNumber)
    }

    @ParameterizedTest
    @CsvSource(
        "6, false, FIRST",
        "5, true, SECOND",
        "5, false, THIRD",
        "4, true, FOURTH",
        "4, false, FOURTH",
        "3, true, FIFTH",
        "3, false, FIFTH"
    )
    fun `로또 당첨 기준에 따라 결과를 판단한다`(matchingNumberCount: Int, bonusNumberMatch: Boolean, expected: WinningRank) {
        val result = Lotto(listOf(1, 2, 3, 4, 5, 6)).calculateLottoRank(matchingNumberCount, bonusNumberMatch)
        assertThat(result).isEqualTo(expected)
    }


    companion object {
        @JvmStatic
        fun provideInvalidElementAmount(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(1, 2, 3, 4)),
            Arguments.of(listOf(1, 2, 3, 4, 5)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7, 8)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7, 9)),
        )

        @JvmStatic
        fun provideDuplicatedElement(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 5)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 1)),
            Arguments.of(listOf(1, 1, 1, 2, 2, 2)),
            Arguments.of(listOf(1, 1, 1, 1, 1, 1)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 1)),
            Arguments.of(listOf(1, 3, 5, 1, 3, 5)),
        )

        @JvmStatic
        fun provideInvalidRangeElement(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 0)),
            Arguments.of(listOf(1, 2, 3, 4, 5, -1)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 46)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 47)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 100)),
        )

        @JvmStatic
        fun provideNormalElement(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(listOf(1, 2, 3, 43, 44, 45)),
            Arguments.of(listOf(6, 5, 4, 3, 2, 1)),
            Arguments.of(listOf(45, 44, 43, 42, 41, 40)),
            Arguments.of(listOf(1, 10, 20, 30, 40, 45)),
        )

        @JvmStatic
        fun provideLottoTestData(): Stream<LottoTestData> {
            val input = setOf(1, 2, 3, 4, 5, 6)
            return Stream.of(
                LottoTestData(
                    lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    inputNumbers = input,
                    matchingCount = 6,
                    bonusNumber = 7,
                    containBonusNumber = false
                ),
                LottoTestData(
                    lotto = Lotto(listOf(1, 2, 3, 43, 44, 45)),
                    inputNumbers = input,
                    matchingCount = 3,
                    bonusNumber = 44,
                    containBonusNumber = true
                ),
                LottoTestData(
                    lotto = Lotto(listOf(6, 5, 4, 3, 2, 1)),
                    inputNumbers = input,
                    matchingCount = 6,
                    bonusNumber = 7,
                    containBonusNumber = false
                ),
                LottoTestData(
                    lotto = Lotto(listOf(45, 44, 43, 42, 41, 40)),
                    inputNumbers = input,
                    matchingCount = 0,
                    bonusNumber = 40,
                    containBonusNumber = true
                ),
            )
        }
    }

}

data class LottoTestData(
    val lotto: Lotto,
    val inputNumbers: Set<Int>,
    val matchingCount: Int,
    val bonusNumber: Int,
    val containBonusNumber: Boolean,
)
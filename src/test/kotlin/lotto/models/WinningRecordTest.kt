package lotto.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningRecordTest {
    private lateinit var winningRecord: WinningRecord

    @BeforeEach
    fun setUp() {
        winningRecord = WinningRecord()
    }

    @ParameterizedTest
    @MethodSource("generateExactWinningRecordTestCases")
    fun `구매한 로또에 대해 당첨 결과들을 정확히 기록한다`(
        purchasedLottos: List<Lotto>,
        winningLotto: Lotto,
        bonus: Bonus,
        expectedRecord: Map<WinningRank, Int>
    ) {
        winningRecord.updateWinningResults(purchasedLottos, winningLotto, bonus)
        val actualRecord = winningRecord.value

        assertThat(actualRecord).isEqualTo(expectedRecord)
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
        val bonus = Bonus(7)
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val expectedResult = true

        val actualResult = winningRecord.hasMatchingBonusNumber(winningLotto, bonus)

        assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `구매 로또 번호 중 일치하는 보너스 번호가 없으면 거짓이다`() {
        val bonus = Bonus(7)
        val purchasedLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expectedResult = false

        val actualResult = winningRecord.hasMatchingBonusNumber(purchasedLotto, bonus)

        assertThat(actualResult).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun generateExactWinningRecordTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(listOf(1, 2, 3, 4, 5, 7))
                    ),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Bonus(7),
                    mapOf(
                        WinningRank.FIRST to 1,
                        WinningRank.SECOND to 1,
                        WinningRank.THIRD to 0,
                        WinningRank.FOURTH to 0,
                        WinningRank.FIFTH to 0,
                        WinningRank.NOTHING to 0
                    )
                ),
                Arguments.of(
                    listOf(
                        Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(listOf(1, 2, 3, 4, 5, 7)),
                        Lotto(listOf(1, 2, 3, 4, 8, 9)),
                        Lotto(listOf(1, 2, 3, 10, 11, 12))
                    ),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Bonus(7),
                    mapOf(
                        WinningRank.FIRST to 1,
                        WinningRank.SECOND to 1,
                        WinningRank.THIRD to 0,
                        WinningRank.FOURTH to 1,
                        WinningRank.FIFTH to 1,
                        WinningRank.NOTHING to 0
                    )
                ),
                Arguments.of(
                    listOf(
                        Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(listOf(1, 2, 3, 4, 5, 8)),
                        Lotto(listOf(1, 2, 3, 4, 9, 10)),
                        Lotto(listOf(1, 2, 3, 12, 13, 14)),
                        Lotto(listOf(6, 15, 16, 17, 18, 19)),
                        Lotto(listOf(20, 21, 22, 23, 24, 25))
                    ),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Bonus(7),
                    mapOf(
                        WinningRank.FIRST to 1,
                        WinningRank.SECOND to 0,
                        WinningRank.THIRD to 1,
                        WinningRank.FOURTH to 1,
                        WinningRank.FIFTH to 1,
                        WinningRank.NOTHING to 2
                    )
                )
            )
        }


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
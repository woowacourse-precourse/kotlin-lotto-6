package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ResultTest {
    private lateinit var result: Result

    @BeforeEach
    fun setUp() {
        result = Result()
    }

    @ParameterizedTest
    @MethodSource("checkRank")
    fun `로또 티켓을 넣었을 때 알맞는 등수가 나오는지 체크`(
        ticket: List<Int>,
        drawNumber: List<Int>,
        bonusNumber: Int,
        expectedRank: Prize,
    ) {
        val rank = result.checkTicket(ticket, drawNumber, bonusNumber)

        assertEquals(expectedRank, rank)
    }

    @ParameterizedTest
    @MethodSource("checkTotalPrize")
    fun `총 상금 체크`(
        countEachPrize: Map<Prize, Int>,
        actualTotalPrize: Int
    ) {
        val totalPrize = result.calculatePrize(countEachPrize)

        assertEquals(totalPrize, actualTotalPrize)
    }

    companion object {
        @JvmStatic
        fun checkRank(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 7, Prize.FIRST),
                Arguments.of(listOf(1, 2, 3, 4, 5, 7), listOf(1, 2, 3, 4, 5, 6), 7, Prize.SECOND),
                Arguments.of(listOf(1, 2, 3, 4, 5, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.THIRD),
                Arguments.of(listOf(1, 2, 3, 4, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.FOURTH),
                Arguments.of(listOf(1, 2, 3, 43, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.FIFTH),
                Arguments.of(listOf(1, 2, 42, 43, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.NONE),
                Arguments.of(listOf(1, 41, 42, 43, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.NONE),
                Arguments.of(listOf(40, 41, 42, 43, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.NONE),

                Arguments.of(listOf(1, 2, 7, 43, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.NONE),
                Arguments.of(listOf(1, 2, 3, 7, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.FIFTH),
                Arguments.of(listOf(1, 2, 3, 4, 7, 45), listOf(1, 2, 3, 4, 5, 6), 7, Prize.FOURTH),
            )
        }

        @JvmStatic
        fun checkTotalPrize(): List<Arguments> {
            return listOf(
                Arguments.of(
                    mapOf(
                        Prize.FIRST to 1, // 2,000,000,000원
                        Prize.SECOND to 2, // 30,000,000원 * 2 = 60,000,000원
                        Prize.THIRD to 3, // 1,500,000원 * 3 = 4,500,000원
                        Prize.FOURTH to 4, // 50,000원 * 4 = 200,000원
                        Prize.FIFTH to 5, // 5,000원 * 5 = 25,000원
                        Prize.NONE to 10 // 0원
                    ),
                    2_064_725_000
                ),
                Arguments.of(
                    mapOf(
                        Prize.FIRST to 1, // 2,000,000,000원
                        Prize.SECOND to 0, // 30,000,000원
                        Prize.THIRD to 0, // 1,500,000원
                        Prize.FOURTH to 0, // 50,000원
                        Prize.FIFTH to 0, // 5,000원
                        Prize.NONE to 0 // 0원
                    ),
                    2_000_000_000
                ),
                Arguments.of(
                    mapOf(
                        Prize.FIRST to 1, // 2,000,000,000원
                        Prize.SECOND to 1, // 30,000,000원
                        Prize.THIRD to 0, // 1,500,000원
                        Prize.FOURTH to 0, // 50,000원
                        Prize.FIFTH to 0, // 5,000원
                        Prize.NONE to 0 // 0원
                    ),
                    2_030_000_000
                ),
                Arguments.of(
                    mapOf(
                        Prize.FIRST to 1,
                        Prize.SECOND to 1,
                        Prize.THIRD to 0,
                        Prize.FOURTH to 1,
                        Prize.FIFTH to 0,
                        Prize.NONE to 10
                    ),
                    2_030_050_000
                ),
            )
        }
    }
}
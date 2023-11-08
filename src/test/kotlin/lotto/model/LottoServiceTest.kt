package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Winner.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeoutPreemptively
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.MockedStatic.Verification
import org.mockito.Mockito
import java.time.Duration
import java.util.*
import java.util.stream.Stream

class LottoServiceTest {

    @DisplayName("로또 구매 메서드 테스트")
    @Test
    fun `buyLotto - 1~45 범위 내의 로또 번호 6개가 생성되는지 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            { LottoService.buyLotto(6000) },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    @DisplayName("구매한 로또에서 당첨내역을 확인해, EnumMap<Winner, Int> 타입을 리턴")
    @ParameterizedTest(name = "로또번호 {1}, 보너스 번호 {2}, 당첨내역 {3}")
    @MethodSource("getWinningMapProvider")
    fun `getWinningMap - 구매한 로또에서 당첨내역을 확인`(purchasedLottoList: List<Lotto>, winningNumber: Lotto, bonusNumber: Int, expectedWinningMap: EnumMap<Winner, Int>) {
        val winningMap = LottoService.getWinningMap(purchasedLottoList, winningNumber, bonusNumber)
        assertEquals(winningMap, expectedWinningMap)
    }

    @Test
    fun getEarningRate() {
    }

    private fun assertRandomUniqueNumbersInRangeTest(
        executable: Executable,
        value: List<Int>,
        vararg values: List<Int>
    ) {
        assertRandomTest(
            { Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()) },
            executable,
            value,
            *values
        )
    }

    private fun <T> assertRandomTest(
        verification: Verification,
        executable: Executable,
        value: T,
        vararg values: T
    ) {
        assertTimeoutPreemptively(
            RANDOM_TEST_TIMEOUT
        ) {
            Mockito.mockStatic(Randoms::class.java).use { mock ->
                mock.`when`<Any>(verification).thenReturn(value, *Arrays.stream(values).toArray())
                executable.execute()
            }
        }
    }

    companion object {
        private val RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L)

        @JvmStatic
        fun getWinningMapProvider(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(
                        Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1등 : Winner.FIRST_GRADE
                        Lotto(listOf(1, 2, 3, 4, 5, 7)), // 2등 : Winner.SECOND_GRADE
                        Lotto(listOf(1, 2, 3, 4, 5, 8)), // 3등 : Winner.THIRD_GRADE
                    ), Lotto(listOf(1, 2, 3, 4, 5, 6)), 7,
                    EnumMap(mapOf(
                        FIRST_GRADE to 1,
                        SECOND_GRADE to 1,
                        THIRD_GRADE to 1,
                    ))
                ),
                Arguments.of(
                    listOf(
                        Lotto(listOf(2, 3, 5, 6, 7, 44)), // 3등 : Winner.THIRD_GRADE
                        Lotto(listOf(2, 3, 4, 5, 10, 11)), // 4등 : Winner.FOURTH_GRADE
                        Lotto(listOf(2, 3, 4, 11, 12, 13)), // 5등 : Winner.FIFTH_GRADE
                    ), Lotto(listOf(2, 3, 4, 5, 6, 7)), 9,
                    EnumMap(mapOf(
                        THIRD_GRADE to 1,
                        FOURTH_GRADE to 1,
                        FIFTH_GRADE to 1,
                    ))
                ),
                Arguments.of(
                    listOf(
                        Lotto(listOf(2, 3, 4, 5, 10, 11)), // 4등 : Winner.FOURTH_GRADE
                        Lotto(listOf(2, 3, 4, 11, 12, 13)), // 5등 : Winner.FIFTH_GRADE
                        Lotto(listOf(2, 3, 18, 25, 38, 44)), // 당첨되지 않음.
                    ), Lotto(listOf(2, 3, 4, 5, 6, 7)), 9,
                    EnumMap(mapOf(
                        FOURTH_GRADE to 1,
                        FIFTH_GRADE to 1,
                    ))
                ),
            )
    }
}
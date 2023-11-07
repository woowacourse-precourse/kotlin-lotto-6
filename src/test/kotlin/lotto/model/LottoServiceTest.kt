package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeoutPreemptively
import org.junit.jupiter.api.function.Executable
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.MockedStatic.Verification
import org.mockito.Mockito
import java.time.Duration
import java.util.*

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

    @Test
    fun getWinningMap() {
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
    }
}
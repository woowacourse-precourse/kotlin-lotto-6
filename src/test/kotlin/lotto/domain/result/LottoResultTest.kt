package lotto.domain.result

import domain.result.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {

    private lateinit var lottoResult: LottoResult

    @BeforeEach
    fun setup() {
        val lotties = listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45),
        )

        val winningNumbers = listOf(1, 15, 26, 33, 35, 42)
        val bonusNumber = 8

        lottoResult = LottoResult(lotties, winningNumbers, bonusNumber)
    }

/*    @Test
    fun `로또 결과`() {
        val actualResult = lottoResult.getResultData()
        assertThat(actualResult).isEqualTo()
    }*/
}
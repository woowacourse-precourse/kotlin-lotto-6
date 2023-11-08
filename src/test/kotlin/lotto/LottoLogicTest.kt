package lotto

import lotto.enums.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoLogicTest {

    @Test
    fun `로또가 주어진 갯수만큼 생성되는지 확인`() {
        val lottoCount = 10
        assertThat(LottoLogic.createLotto(lottoCount))
            .hasSize(lottoCount)
    }

    @Test
    fun `로또 결과가 올바르게 계산되는지 확인`() {
        val winningNumbers = (1..6).toList()
        val bonusNumber = 7
        val lotto = listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        ).map { Lotto(it) }

        val results = LottoLogic.calculateLottoResults(lotto, winningNumbers, bonusNumber)
        assertThat(results)
            .containsExactlyInAnyOrderEntriesOf(
                mapOf(
                    LottoResult.FIFTH to 1,
                    LottoResult.NOTHING to 7
                ),
            )
    }

    @Test
    fun `로또 결과가 올바르게 문자열로 변환되는지 확인`() {
        val results = mapOf(
            LottoResult.NOTHING to 10,
            LottoResult.FIRST to 3,
            LottoResult.SECOND to 4,
            LottoResult.THIRD to 7,
            LottoResult.FIFTH to 19,
            LottoResult.FOURTH to 5
        )

        assertThat(LottoLogic.calculateLottoResultMessages(results))
            .containsExactly(
                "3개 일치 (5,000원) - 19개",
                "4개 일치 (50,000원) - 5개",
                "5개 일치 (1,500,000원) - 7개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 4개",
                "6개 일치 (2,000,000,000원) - 3개",
            )
    }

}
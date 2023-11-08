package accuracy

import lotto.domain.GameResult
import lotto.domain.LottoManager
import lotto.model.Lotto
import lotto.model.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccuracyTest {
    private val lottoManager = LottoManager()

    @Test
    fun `수익률 계산 정확성 테스트`() {
        val purchasePrice = 5000
        val totalProceeds = 5000
        val managerResult = lottoManager
            .calculateResult(purchasePrice, totalProceeds)
        val trueResult = "100.0"
        assertThat(managerResult).isEqualTo(trueResult)
    }

    @Test
    fun `lotto 번호에 보너스 넘버 포함 테스트`() {
        val gameResult = GameResult.THIRD
        val winningLotto = WinningLotto(setOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val managerResult = lottoManager
            .checkBonusResult(gameResult, winningLotto, lotto)
        assertThat(managerResult).isEqualTo(GameResult.SECOND)
    }

    @Test
    fun `lotto 번호에 보너스 넘버 비포함 테스트`() {
        val gameResult = GameResult.THIRD
        val winningLotto = WinningLotto(setOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val managerResult = lottoManager
            .checkBonusResult(gameResult, winningLotto, lotto)
        assertThat(managerResult).isEqualTo(GameResult.THIRD)
    }

    @Test
    fun `lotto 번호에 보너스 넘버는 포함되지만 matchNumber이 5가 아닌 경우 테스트`() {
        val gameResult = GameResult.FOURTH
        val winningLotto = WinningLotto(setOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 7))
        val managerResult = lottoManager
            .checkBonusResult(gameResult, winningLotto, lotto)
        assertThat(managerResult).isEqualTo(GameResult.FOURTH)
    }

    @Test
    fun `matchCount에 따른 올바른 GameResult 반환 테스트`() {
        val matchCount = 4
        val managerResult = lottoManager.getMathResult(matchCount)
        assertThat(managerResult).isEqualTo(GameResult.FOURTH)
    }
}
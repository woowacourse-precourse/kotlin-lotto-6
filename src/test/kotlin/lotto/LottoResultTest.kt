package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("LottoResult 테스트")
class LottoResultTest {

    @Test
    @DisplayName("유효한 winningCount로 초기화")
    fun `유효한 winningCount로 초기화`() {
        val lottoResult = LottoResult(winningCount = 3)
    }

    @Test
    @DisplayName("winningCount가 범위를 벗어날 경우 예외 발생")
    fun `winningCount가 범위를 벗어날 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoResult(winningCount = 7)
        }
    }

    @Test
    @DisplayName("유효한 bonusJudge로 초기화")
    fun `유효한 bonusJudge로 초기화`() {
        val lottoResult = LottoResult(bonusJudge = true)
    }

}
package lotto

import lotto.domain.controller.LottoController
import lotto.data.model.Lotto
import lotto.domain.util.RateOfReturnCalculator.calculateRateOfReturn
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    val lottoController = LottoController()

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
    @Test
    fun `로또 번호의 개수가 6개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `총 수익률이 100 일 때`() {
        assert(calculateRateOfReturn(5000, 5) == "100.0")
    }

    @Test
    fun `총 수익률이 100보다 클 때`() {
        assert(calculateRateOfReturn(5000, 1) == "500.0")
    }

    @Test
    fun `총 수익률이 100보다 작을 때`() {
        assert(calculateRateOfReturn(5000, 30) == "16.7")
    }
}

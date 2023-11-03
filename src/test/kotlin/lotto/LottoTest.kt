package lotto

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

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 금액이 1000 단위가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoController.checkLottoCost(1001)
        }
    }

    @Test
    fun `로또 금액이 0 이하인 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoController.checkLottoCost(0)
        }
    }

    // 아래에 추가 테스트 작성 가능
}

package lotto.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoControllerTest {

    @Test
    fun `정상 범위 내의 1000원 단위인 로또 구입 금액 입력`() {
        assertDoesNotThrow {
            inputLottoAmount(14000)
        }
    }

    @Test
    fun `정상 범위 내의 1000원 단위가 아닌 로또 구입 금액 입력`() {
        assertThrows<IllegalArgumentException> {
            inputLottoAmount(14500)
        }
    }

    @Test
    fun `정상 범위 밖의 1000원 단위인 로또 구입 금액 입력`() {
        assertThrows<IllegalArgumentException> {
            inputLottoAmount(4_611_686_019_000)
        }
    }
}
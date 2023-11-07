package lotto

import lotto.domain.LottoMC
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMCTest {

    @Test
    fun `로또 번호의 개수가 6개가 넘어갈 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickLottoNum("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `로또 번호 범위가 1~45 사이가 아닐 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickLottoNum("1,2,3,4,5,46")
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있을 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickLottoNum("1,2,3,4,5,5")
        }
    }
}
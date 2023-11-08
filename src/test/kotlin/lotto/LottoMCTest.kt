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

    @Test
    fun `로또 번호가 공백일 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickLottoNum("")
        }
    }

    @Test
    fun `로또 보너스 번호 범위가 1~45 사이가 아닐 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickBonusNum("46", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 보너스 번호가 당첨 번호와 중복될 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickBonusNum("1", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 보너스 번호가 공백일 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickBonusNum("", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 보너스 번호가 비어있을 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickBonusNum(" ", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 보너스 번호를 여러 개 입력했을 때의 예외처리`() {
        assertThrows<IllegalArgumentException> {
            LottoMC().pickBonusNum("22,34", listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
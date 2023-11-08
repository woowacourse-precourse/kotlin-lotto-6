package lotto

import lotto.model.BonusNumberVerification
import lotto.model.Lotto
import lotto.model.LottoNumberGenerator
import lotto.model.PurchaseMoneyVerification
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows



class LottoTest{
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
    fun `로또 구입 금액이 천원 단위가 아니면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            PurchaseMoneyVerification("2500")
        }
    }

    @Test
    fun `보너스 번호는 당첨 번호와 중복되면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            BonusNumberVerification(5,listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `로또 번호가 1이상 45이하가 아니라면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `구입한 로또 번호 만큼 로또를 생성하는지 테스트`() {
        val lottoNumbers = LottoNumberGenerator()
        val lotto = 5
        val result = lottoNumbers.lottoNumberCreation(lotto)

        assertEquals(lotto, result.size)
    }

    @Test
    fun `구입한 로또 하나가 고유한 6개의 숫자를 가지고 있는지 테스트`() {
        val lottoNumbers = LottoNumberGenerator()
        val lotto = 1
        val result = lottoNumbers.lottoNumberCreation(lotto)

        assertTrue { result[0].distinct().size == 6 }
    }
}

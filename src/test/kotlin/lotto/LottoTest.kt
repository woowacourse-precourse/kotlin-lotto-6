package lotto

import lotto.model.BonusNumberVerification
import lotto.model.Lotto
import lotto.model.PurchaseMoneyVerification
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
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
            PurchaseMoneyVerification().inputMoneyCheck(2500)
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
    // 아래에 추가 테스트 작성 가능
}

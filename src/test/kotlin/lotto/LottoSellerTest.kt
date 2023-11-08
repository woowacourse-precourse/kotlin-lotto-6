package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoSellerTest {
    @Test
    fun `보너스 번호가 로또 당첨 번호와 중복되면 예외가 발생한다`() {
        val seller = LottoSeller()
        seller.winningNumbers = arrayListOf(1,2,3,4,5,6)
        seller.bonusNumber = 6
        assertThrows<IllegalArgumentException> {
            seller.validateBonusNumber()
        }
    }

    @Test
    fun `보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다`() {
        val seller = LottoSeller()
        seller.winningNumbers = arrayListOf(1,2,3,4,5,6)
        seller.bonusNumber = 47
        assertThrows<IllegalArgumentException> {
            seller.validateBonusNumber()
        }
    }

    @Test
    fun `구입금액은 1000원 이상이어야 합니다`() {
        val seller = LottoSeller()
        assertThrows<IllegalArgumentException> {
            seller.buyTickets(800)
        }
    }

    @Test
    fun `구입금액은 1000원 단위여야 합니다`() {
        val seller = LottoSeller()
        assertThrows<IllegalArgumentException> {
            seller.buyTickets(1800)
        }
    }
}
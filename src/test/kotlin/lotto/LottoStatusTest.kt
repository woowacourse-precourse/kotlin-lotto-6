package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoStatusTest {
    val myBuyLotto = LottoStatus()

    @Test
    fun `로또 구매 가격에 문자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            myBuyLotto.validatePrice("1000k")
        }
    }
    @Test
    fun `로또 구매 가격이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            myBuyLotto.validatePrice("900")
        }
    }
    @Test
    fun `로또 구매 가격이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            myBuyLotto.validatePrice("9900")
        }
    }
    @Test
    fun `로또 구매 수량만큼 로또 번호를 뽑는다`() {
        myBuyLotto.countOfLotto = 6
        myBuyLotto.pickLotto()
        assertThat(myBuyLotto.myLottos.size).isEqualTo(6)
    }
}
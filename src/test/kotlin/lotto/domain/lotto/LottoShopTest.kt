package lotto.domain.lotto

import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `로또 구매 - 정상 입력`() {
        // given
        val input = Money(5000)
        // when
        val result = LottoShop.purchaseLottos(input)
        // then
        assertEquals(result.size(), 5)
    }

    @Test
    fun `로또 구매 - 1,000으로 나뉘어 지지 않는 값 예외 처리`() {
        // given
        val input = Money(1001)
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoShop.purchaseLottos(input) }
            .withMessage("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.")
    }

    @Test
    fun `로또 구매 - 1,000 미만 값 예외 처리`() {
        // given
        val input = Money(500)
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoShop.purchaseLottos(input) }
            .withMessage("[ERROR] 구입금액은 최소 1,000원 이상 입력해야 합니다.")
    }
}
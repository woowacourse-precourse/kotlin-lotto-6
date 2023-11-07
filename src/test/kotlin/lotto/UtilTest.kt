package lotto

import lotto.model.Lotto
import lotto.model.PurchasedLotto
import lotto.utility.Utils
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UtilTest {
    @Test
    fun `소수점 2번째 자리에서 반올림 테스트`() {
        val number = 12.34
        val roundedNumber = Utils.roundToOneDeimalPlace(number)

        Assertions.assertThat(roundedNumber).isEqualTo(12.3)
    }
}
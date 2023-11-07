package lotto

import lotto.domain.Chance
import lotto.domain.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultViewTest {

    @Test
    fun `입력받은 구매 금액에 따른 발행 가능 횟수 출력`() {
        val money = Money(5000)
        val chance = Chance(money)
        assertThat(chance.getChanceTimes()).isEqualTo(5)
    }
}
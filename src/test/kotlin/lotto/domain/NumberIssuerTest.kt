package lotto.domain

import lotto.utils.Constant
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

private const val FIVE_LOTTOS = 5

class NumberIssuerTest {
    val money = 5000

    @Test
    fun `발행된 숫자 List의 size는 6이어야 한다`() {
        val numbers = NumberIssuer.issueNumbers(money)
        Assertions.assertThat(Constant.LOTTO_NUMBER_SIZE.equals(numbers.size))
    }

    @Test
    fun `발행된 숫자는 서로 다른 숫자여야 한다`() {
        val numbers = NumberIssuer.issueNumbers(money)
        Assertions.assertThat(numbers.size.equals(numbers.toSet().size))
    }

    @Test
    fun `구매한 로또의 갯수만큼 로또를 발행해 줘야 한다`() {
        Assertions.assertThat(FIVE_LOTTOS).isEqualTo(NumberIssuer.issueNumbers(5000).size)
    }
}
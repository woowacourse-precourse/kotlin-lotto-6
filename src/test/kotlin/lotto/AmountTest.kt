package lotto

import lotto.amount.Amount
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.IllegalArgumentException

class AmountTest {
    
    @ParameterizedTest
    @ValueSource(strings = ["asd", "2000ab"])
    fun `숫자가 아닌 문자를 입력했을 때`(amount: String) {
        assertThrows<IllegalArgumentException> {
            Amount(amount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-10000"])
    fun `0이하의 숫자를 입력했을 때`(amount: String) {
        assertThrows<IllegalArgumentException> {
            Amount(amount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1500", "239450"])
    fun `1000원 단위로 나누어 떨어지지 않을 때`(amount: String) {
        assertThrows<IllegalArgumentException> {
            Amount(amount)
        }
    }

}
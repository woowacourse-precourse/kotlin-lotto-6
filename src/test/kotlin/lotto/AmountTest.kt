package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class AmountTest {
    
    @ParameterizedTest
    @ValueSource(strings = ["asd", "2000ab"])
    fun `숫자가 아닌 문자를 입력했을 때`(amount: String) {
        assertThrows<IllegalArgumentException> {
            Amount(amount)
        }
    }
}
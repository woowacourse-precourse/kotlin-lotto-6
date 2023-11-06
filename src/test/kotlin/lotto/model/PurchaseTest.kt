package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class PurchaseTest {

    @ParameterizedTest
    @DisplayName("유효하지 않은 값이 들어가면 예외가 발생한다.")
    @ValueSource(ints = [3021, 1001, -1000])
    fun constructorTest(input: Int) {
        assertThrows<IllegalArgumentException> {
            Purchase(input)
        }
    }

    @ParameterizedTest
    @DisplayName("유효한 값이 들어가면 1000원으로 나눈 값으로 초기화한다.")
    @CsvSource(value = ["8000:8", "2000:2", "100000:100"], delimiter = ':')
    fun validConstructTest(input: Int, expected: Int) {
        val purchaseCount = Purchase(input)
        val validation = purchaseCount.count
        assertThat(validation).isEqualTo(expected)
    }
}
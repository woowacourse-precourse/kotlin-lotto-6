package lotto.validator

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class ValidatorTest {
    val validator = Validator()

    @Test
    @DisplayName("범위 안의 수를 검증하는 테스트")
    fun numInRangeTest() {
        val num = 49
        assert(num == validator.validatedNumberInRange(num, num - 1, num + 1))
        assertThrows<IllegalArgumentException> {
            validator.validatedNumberInRange(num, 1, 45)
        }
    }

    @Test
    @DisplayName("input금액을 검증하는 테스트")
    fun inputMoneyTest() {
        assert(validator.validatedMoneyIsInt("1000") == 1000)
        assertThrows<IllegalArgumentException> {
            validator.validatedMoneyUnit(1234, 1000)
        }
    }
}
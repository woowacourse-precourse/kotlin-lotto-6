package lotto.validator.numbers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DuplicatedValidatorTest {
    @Test
    fun `리스트 내 중복된 숫자가 있으면 예외 발생`() {
        val duplicatedValidator = DuplicatedValidator()
        val numbers = listOf(1, 2, 2, 4, 5, 6)

        assertThrows<IllegalArgumentException>("로또 번호 $numbers 는 중복되면 안됩니다") {
            duplicatedValidator.validate(numbers)
        }
    }
}
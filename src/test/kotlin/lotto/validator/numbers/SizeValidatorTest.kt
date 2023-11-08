package lotto.validator.numbers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SizeValidatorTest {
    @Test
    fun `List 크기가 6이 아니면 예외`() {
        val sizeValidator = SizeValidator()
        val invalidNumbers = listOf(1, 2, 3, 4, 5)
        val inValidNumbers2 = listOf(1, 2, 3, 4, 5, 6, 7)

        assertThrows<IllegalArgumentException>("로또 번호 %s 는 6개여야 합니다") {
            sizeValidator.validate(invalidNumbers)
        }
        assertThrows<IllegalArgumentException>("로또 번호 %s 는 6개여야 합니다") {
            sizeValidator.validate(inValidNumbers2)
        }
    }
}
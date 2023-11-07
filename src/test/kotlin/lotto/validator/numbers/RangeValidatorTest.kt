package lotto.validator.numbers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RangeValidatorTest {
    @Test
    fun `List 내 숫자들이 45이하 자연수가 아니면 예외 발생`() {
        val rangeValidator = RangeValidator()
        val invalidNumbers = listOf(0)
        val inValidNumbers2 = listOf(46)

        assertThrows<IllegalArgumentException>("로또 번호 $invalidNumbers 는 1 ~ 45 사이여야 합니다") {
            rangeValidator.validate(invalidNumbers)
        }
        assertThrows<IllegalArgumentException>("로또 번호 $inValidNumbers2 는 1 ~ 45 사이여야 합니다") {
            rangeValidator.validate(inValidNumbers2)
        }
    }
}
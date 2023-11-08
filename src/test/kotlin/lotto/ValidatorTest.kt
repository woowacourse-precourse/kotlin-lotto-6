package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 43, 500, 1111, 10001])
    fun `구매금액을 1000원 단위로 안 쓴 경우 에러발생 테스트`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Validator.isAvailableUnit(input)
        }
    }

    @Test
    fun `당첨번호 입력에 숫자를 제외한 문자열이나 공백이 들어간 경우 에러발생 테스트`() {
        Assertions.assertAll(
            Executable { assertThrows<IllegalArgumentException> { Validator.mapToWinningNumbers("1,2,3, ,4,5,6") } },
            Executable { assertThrows<IllegalArgumentException> { Validator.mapToWinningNumbers("1,2,3,,4,5,6") } },
            Executable { assertThrows<IllegalArgumentException> { Validator.mapToWinningNumbers("1,2,3,d,f,5,6") } },
            Executable { assertThrows<IllegalArgumentException> { Validator.mapToWinningNumbers("1,2,3,d,f,5,,") } },
            Executable { assertThrows<IllegalArgumentException> { Validator.mapToWinningNumbers(",,2,3,d,f,5,,") } }
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "12000", "30000"])
    fun `구매금액을 1000원 단위로 쓴 경우 예상 답이 나오는지 테스트`(input: String) {
        assertEquals(input.toInt(), Validator.convertToNumber(input))
    }

    @Test
    fun `로또번호 or 당첨번호가 6자리가 아닐 경우 에러발생 테스트`() {
        assertThrows<IllegalArgumentException> { Validator.isAvailableLength(listOf(1, 2, 3, 4, 5).size) }
    }

    @Test
    fun `1~45범위를 벗어난 수가 있을 경우 에러발생 테스트`() {
        Assertions.assertAll(
            //당첨 번호 테스트
            Executable {
                assertThrows<IllegalArgumentException> {
                    listOf(
                        1,
                        2,
                        3,
                        4,
                        5,
                        77
                    ).map { Validator.isAvailableRange(it) }
                }
            },
            //보너스 번호 테스트
            Executable { assertThrows<IllegalArgumentException> { Validator.isAvailableRange(46) } },
        )

    }

    @Test
    fun `로또번호 or 당첨번호에 중복된 수가 있을 경우 에러발생 테스트`() {
        assertThrows<IllegalArgumentException> { Validator.isDuplicatedNumber(listOf(1, 2, 3, 4, 5, 5)) }
    }

    @Test
    fun `로또번호 or 당첨번호 형식이 올바른 경우 예상 답이 나오는지 테스트`() {
        assertEquals(listOf(1, 2, 3, 4, 5, 45), Validator.validateNumbers(listOf(1, 2, 3, 4, 5, 45)))
    }
}
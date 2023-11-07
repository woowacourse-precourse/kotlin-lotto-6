package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DrawTest {
    private lateinit var draw: Draw

    @BeforeEach
    fun setUp() {
        draw = Draw()
    }

    @Test
    fun `입력이 없을 때`() {
        val input = ""

        val exception = assertThrows<IllegalArgumentException> {
            draw.validateDrawNumber(input)
        }

        assertEquals(exception.message, NOT_EMPTY)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "      "])
    fun `입력이 공백일 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateDrawNumber(input)
        }

        assertEquals(exception.message, NOT_BLANK)
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456", "1 2 3 4 5 6", "1,2,3,4,5", "일이삼사오육"])
    fun `쉼표로 구분해 6개의 값이 들어오지 않았을 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateDrawNumber(input)
        }

        assertEquals(exception.message, MUST_SIX_VALUE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5, 6", "ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,ㅂ", "1,2,3,4,5,a", "1,2,3,4,5,2147483648", "1,2,3,4,5,-2147483649"])
    fun `6개의 값이 들어왔지만 숫자가 아닌 값이 있을 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateDrawNumber(input)
        }

        assertEquals(exception.message, MUST_SIX_NUMBER)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,0", "1,2,3,4,5,46", "1,2,3,4,5,2147483647", "1,2,3,4,5,-2147483648"])
    fun `6개의 값이 모두 정수이지만 1~45사이의 숫자가 아닐 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateDrawNumber(input)
        }

        assertEquals(exception.message, MUST_1_TO_45)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5", "1,1,1,1,1,1"])
    fun `6개의 값이 모두 정수이고 1~45사이의 숫자이지만 중복된 숫자가 있을 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateDrawNumber(input)
        }

        assertEquals(exception.message, NOT_DUPLICATE)
    }

    @Test
    fun `보너스) 입력이 없을 때`() {
        val input = ""

        val exception = assertThrows<IllegalArgumentException> {
            draw.validateBonusNumber(input, TEST_DRAW_NUMBER)
        }

        assertEquals(exception.message, NOT_EMPTY)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "   "])
    fun `보너스) 공백만 있을 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateBonusNumber(input, TEST_DRAW_NUMBER)
        }

        assertEquals(exception.message, NOT_BLANK)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "가나다", "후", "1,2"])
    fun `보너스) 하나의 숫자만 입력하지 않았을 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateBonusNumber(input, TEST_DRAW_NUMBER)
        }

        assertEquals(exception.message, BONUS_ONLY_INT)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "46"])
    fun `보너스) 1~45사이의 숫자가 아닐 떄`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateBonusNumber(input, TEST_DRAW_NUMBER)
        }

        assertEquals(exception.message, BONUS_MUST_1_TO_45)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    fun `보너스) 당첨번호와 중복된 숫자일 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            draw.validateBonusNumber(input, TEST_DRAW_NUMBER)
        }

        assertEquals(exception.message, BONUS_NOT_DUPLICATE_DRAW.format(TEST_DRAW_NUMBER.joinToString((","))))
    }


    companion object {
        // 사용자를 혼내는 게 아니다. 에러 메시지를 보고 제대로 입력할 수 있도록 유도해야 한다.
        const val NOT_EMPTY = "아무것도 입력하지 않았어요."
        const val NOT_BLANK = "공    백만 있어요."

        // drawNumber
        const val MUST_SIX_VALUE = "6개의 숫자를 입력해주세요. 입력 예시 -> 1,6,11,23,37,45"
        const val MUST_SIX_NUMBER = "입력값중 숫자가 아닌게 있어요. 입력 예시 -> 1,6,11,23,37,45"
        const val MUST_1_TO_45 = "1~45사이의 숫자가 아닌게 있어요. 입력 예시 -> 1,6,11,23,37,45"
        const val NOT_DUPLICATE = "중복된 숫자가 있어요"

        // bonusNumber
        const val BONUS_ONLY_INT = "하나의 숫자만 입력해주세요. 입력 예시 -> 16"
        const val BONUS_MUST_1_TO_45 = "1~45사이의 숫자가 아닌게 있어요. 입력 예시 -> 16"
        const val BONUS_NOT_DUPLICATE_DRAW = "당첨 번호 %s와 중복된 숫자가 있어요"

        val TEST_DRAW_NUMBER = listOf(1, 2, 3, 4, 5, 6)
    }
}
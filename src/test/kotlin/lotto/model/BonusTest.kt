package lotto.model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusTest {
    private val input = listOf(1, 2, 3, 4, 5, 6)

    @ParameterizedTest
    @DisplayName("보너스 숫자가 올바르지 않은 번호면 예외가 발생한다.")
    @ValueSource(ints = [-1, 46, 0])
    fun bonusConstructTest(input: Int) {
        assertThrows<IllegalArgumentException> {
            Bonus(input)
        }
    }

    @ParameterizedTest
    @DisplayName("보너스 숫자가 주어진 리스트에 중복된 숫자면 예외가 발생한다.")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun checkUniqueNumberTest() {
        assertThrows<IllegalArgumentException> {
            val bonus = Bonus(1)
            bonus.checkUniqueNumber(input)
        }
    }
}
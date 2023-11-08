package lotto

import lotto.model.hasNoDuplicateNumbers
import lotto.model.isLottoNumber
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoBonusTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`(input: String) {
        val winNumber = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            input.hasNoDuplicateNumbers(winNumber)
        }
    }
}
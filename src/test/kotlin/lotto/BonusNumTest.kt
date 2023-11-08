package lotto

import lotto.domain.BonusNum
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class BonusNumTest {
    @Test
    fun `보너스 번호 입력 시 숫자 아닌 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            BonusNum("10j")
        }
    }

    @Test
    fun `보너스 번호 입력 시 1부터 45의 범위에 속하지 않는 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            BonusNum("48")
        }
    }

}

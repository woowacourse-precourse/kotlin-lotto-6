package lotto

import lotto.data.Winning
import org.junit.jupiter.api.*

class WinningTest {

    @Nested
    @DisplayName("당첨 번호")
    inner class WinningNumbersTest {

        @Test
        @DisplayName("로또 예외")
        fun `당첨 번호가 로또 번호의 기준을 만족하지 못 할 때 예외 발생`() {
            val winningNumbers = listOf(
                listOf(1, 2, 3, 4, 5, 6, 7),
                listOf(1, 1, 2, 3, 4, 5),
                listOf(0, 1, 2, 3, 4, 5)
            )

            assertAll(
                {
                    assertThrows<IllegalArgumentException> {
                        Winning(winningNumbers[0], 10)
                    }
                },
                {
                    assertThrows<IllegalArgumentException> {
                        Winning(winningNumbers[1], 10)
                    }
                },
                {
                    assertThrows<IllegalArgumentException> {
                        Winning(winningNumbers[2], 10)
                    }
                }
            )
        }
    }

    @Nested
    @DisplayName("보너스 번호")
    inner class BonusNumberTest {

        @Test
        @DisplayName("숫자 범위 초과")
        fun `보너스 번호가 1 부터 45 이외의 숫자일 때 예외 발생`() {
            assertThrows<IllegalArgumentException> {
                Winning(listOf(1,2,3,4,5,6), 0)
            }
        }

        @Test
        @DisplayName("중복 여부")
        fun `보너스 번호가 당첨 번호와 중복될 때 예외 발생`() {
            assertThrows<IllegalArgumentException> {
                Winning(listOf(1,2,3,4,5,6), 3)
            }
        }
    }
}
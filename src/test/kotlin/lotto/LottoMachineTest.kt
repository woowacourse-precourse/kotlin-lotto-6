package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import lotto.domain.LottoMachine
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {

    private val lottoMachine = LottoMachine()

    @Test
    fun `당첨 번호가 1~45 범위의 숫자가 아니면 예외가 발생한다`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoMachine.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 46))
            }
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoMachine.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5))
            }
        }
    }

    @Test
    fun `당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoMachine.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7))
            }
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아니면 예외가 발생한다`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoMachine.validateBonusNumber("a", listOf(1, 2, 3, 4, 5, 6))
            }
        }
    }

    @Test
    fun `보너스 번호를 입력하지 않으면 예외가 발생한다`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoMachine.validateBonusNumber(" ", listOf(1, 2, 3, 4, 5, 6))
            }
        }
    }

    @Test
    fun `보너스 번호가 1~45 범위의 숫자가 아니면 예외가 발생한다`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoMachine.validateBonusNumber("46", listOf(1, 2, 3, 4, 5, 6))
            }
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoMachine.validateBonusNumber("6", listOf(1, 2, 3, 4, 5, 6))
            }
        }
    }
}
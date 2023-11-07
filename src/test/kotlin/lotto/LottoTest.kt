package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 번호는 1~45 사이의 숫자가 아니면 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 46, 27, 33, 8, 15))
        }
    }

    @Test
    fun `로또 번호 정상 출력 테스트`() {
        val lotto = Lotto(listOf(3, 4, 1, 2, 6, 5))
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `로또 번호 정상 입력 테스트`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertThat(lotto.toString()).isEqualTo(numbers.sorted().toString())
    }

    @Test
    fun `보너스 번호는 1~45 사이의 숫자가 아니면 예외를 발생시킨다`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            validateBonusNumber(46, winningNumbers)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            validateBonusNumber(1, winningNumbers)
        }
    }

    @Test
    fun `보너스 번호 정상 입력 테스트`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertDoesNotThrow { validateBonusNumber(7, winningNumbers) }
    }

    @Test
    fun `로또 당첨 확인시 당첨 번호와 일치하는 번호가 있으면 당첨된 것으로 처리한다`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10
        val rank = ticket.match(winningNumbers, bonusNumber)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `로또 당첨 확인시 보너스 번호가 일치하면 2등으로 처리한다`() {
        val ticket = Lotto(listOf(1, 2, 3, 7, 8, 10))
        val winningNumbers = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10
        val rank = ticket.match(winningNumbers, bonusNumber)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }
    
}
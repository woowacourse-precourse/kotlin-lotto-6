package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
  @Test
  fun `당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      WinningLotto(listOf(1, 2, 3, 4, 5, 6, 7), listOf(8))
    }
  }

  @Test
  fun `당첨 번호의 개수가 6개가 안 되면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      WinningLotto(listOf(1, 2, 3, 4, 5), listOf(8))
    }
  }

  @Test
  fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      WinningLotto(listOf(1, 2, 3, 4, 5, 5), listOf(8))
    }
  }

  @Test
  fun `보너스 번호가 1개가 넘어가면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      WinningLotto(listOf(1, 2, 3, 4, 5, 6), listOf(8, 9))
    }
  }

  @Test
  fun `보너스 번호가 1개가 안 되면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      WinningLotto(listOf(1, 2, 3, 4, 5, 6), listOf())
    }
  }

  @Test
  fun `당첨 번호와 보너스 번호 간에 중복된 숫자가 있으면 예외가 발생한다`() {
    assertThrows<IllegalArgumentException> {
      WinningLotto(listOf(1, 2, 3, 4, 5, 6), listOf(3))
    }
  }
}
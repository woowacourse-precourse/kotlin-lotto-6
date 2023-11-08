package lotto.domain

import lotto.model.Lotto
import lotto.model.WinningLotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows



class InputBonusNumber {
    @Test
    fun `보너스 번호가 당첨 로또에 포함되어 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val winningLottoNumbers = Lotto(listOf(1,2,3,4,5,6))
            val bonusNumber = 6
            WinningLotto(winningLottoNumbers, bonusNumber)
        }
    }
}

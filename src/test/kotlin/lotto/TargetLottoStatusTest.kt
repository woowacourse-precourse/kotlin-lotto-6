package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TargetLottoStatusTest {
    val myTargetLottoStatus = TargetLottoStatus()
    @Test
    fun `로또 당첨 번호에 문자가 존재하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            myTargetLottoStatus.putValidNumberIntoLottoNumbers("1,2,3,4,5,k")
        }
    }
    @Test
    fun `로또 당첨 번호의 범위가 1~45를 넘으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            myTargetLottoStatus.putValidNumberIntoLottoNumbers("77,1,2,3,4,5")
        }
    }
    @Test
    fun `보너스 번호가 로또 당첨 번호에 포함되어있다면 예외가 발생한다`() {
        myTargetLottoStatus.lottoNumbers = mutableListOf(1,2,3,4,5,6)
        myTargetLottoStatus.bonusNumber = 4
        assertThrows<IllegalArgumentException> {
            myTargetLottoStatus.validateBonusNumberIsDuplicateWithLottoNumbers()
        }
    }
}
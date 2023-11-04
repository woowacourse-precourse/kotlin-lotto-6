package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

//import org.junit.Test
//import kotlin.test.assertEquals
//import kotlin.test.assertFalse
//import kotlin.test.assertTrue

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






    // picklottoclass 메서드가 올바른 범위의 번호를 생성하는지 테스트합니다.
    @Test
    fun testPickLottoClassGeneratesCorrectRange() {
        val lottoNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6)).picklottoclass()
        assertTrue(lottoNumbers.all { it in 1..45 })
        assertEquals(6, lottoNumbers.distinct().size)
    }

    // pickbonusclass 메서드가 picknumber에 없는 번호를 잘 생성하는지 테스트합니다.
    @Test
    fun testPickBonusClassGeneratesUniqueNumber() {
        val lottoInstance = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = lottoInstance.pickbonusclass()
        assertFalse(lottoInstance.picknumber.contains(bonusNumber))
    }

    // 당첨 번호 체크 로직이 올바른지 테스트합니다.
    @Test
    fun testCheckWinningLogic() {
        val lottoInstance = Lotto(listOf(1, 2, 3, 4, 5, 6))
        // picknumber를 강제로 설정하여 테스트합니다.
        lottoInstance.picknumber = mutableListOf(1, 2, 3, 7, 8, 9)
        // bonusnumber를 강제로 설정하여 테스트합니다.
        lottoInstance.bonusnumber = 10
        lottoInstance.checkdangcheonm()
        assertEquals(3, lottoInstance.containnumber)
        assertFalse(lottoInstance.bonuscontain)

        // 보너스 번호까지 맞는 경우 테스트합니다.
        lottoInstance.picknumber = mutableListOf(1, 2, 3, 4, 5, 10)
        lottoInstance.checkdangcheonm()
        assertEquals(5, lottoInstance.containnumber)
        assertTrue(lottoInstance.bonusnumber in lottoInstance.lottonumber)
    }

    // 상금 계산 로직이 올바른지 테스트합니다.
    @Test
    fun testPrizeCalculation() {
        val lottoInstance = Lotto(listOf(1, 2, 3, 4, 5, 6))
        // picknumber와 bonusnumber를 강제로 설정하여 테스트합니다.
        lottoInstance.picknumber = mutableListOf(1, 2, 3, 7, 8, 9)
        lottoInstance.bonusnumber = 10
        lottoInstance.checkdangcheonm()
        lottoInstance.checkdangcheonm2()
        assertEquals(5000, lottoInstance.money)

        // 상금이 없는 경우도 테스트합니다.
        lottoInstance.picknumber = mutableListOf(7, 8, 9, 10, 11, 12)
        lottoInstance.checkdangcheonm()
        lottoInstance.checkdangcheonm2()
        assertEquals(0, lottoInstance.money)
    }
}


package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import lotto.enums.LottoResult
import lotto.model.LottoModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoModelTest {

    private lateinit var lottoModel: LottoModel

    @BeforeEach
    fun setUp() {
        lottoModel = LottoModel()
    }

    @Test
    fun `generateLottoNumbers가 금액에 맞게 로또 번호를 생성하는지 테스트`() {
        lottoModel.generateLottoNumbers(5000) // 유효한 금액
        val lottoNumbers = lottoModel.getLottoNumbers()
        assertEquals(5, lottoNumbers.size) // 5개의 로또 번호 생성
        assertTrue(lottoNumbers.all { it.size == 6 }) // 각 로또 번호는 6개의 숫자로 이루어짐
    }

    @Test
    fun `calculateLotto가 제대로 로또결과를 추첨하는지 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                lottoModel.generateLottoNumbers(6000)
                lottoModel.setWinningNumbers("1,2,3,4,5,6")
                lottoModel.setBonusNumbers("7")
                val results = lottoModel.calculateLotto()

                assertEquals(1, results[LottoResult.MATCH_SIX])
                assertEquals(1, results[LottoResult.MATCH_FIVE])
                assertEquals(1, results[LottoResult.MATCH_FOUR])
                assertEquals(1, results[LottoResult.MATCH_THREE])
                assertEquals(1, results[LottoResult.MATCH_FIVE_BONUS])
            },
            listOf(1, 2, 3, 4, 5, 6), // 1등
            listOf(1, 2, 3, 4, 5, 7), // 2등 + 보너스볼
            listOf(1, 2, 3, 4, 44, 45), // 3등
            listOf(1, 2, 3, 43, 44, 45), // 4등
            listOf(1, 2, 42, 43, 44, 45), // notmatch
            listOf(1, 2, 3, 4, 5, 40)// 2등
        )
    }

    @Test
    fun `calculatorProfit이 제대로 수익률을 검사하는지 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                lottoModel.generateLottoNumbers(5000)
                lottoModel.setWinningNumbers("1,2,3,4,5,6")
                lottoModel.setBonusNumbers("7")
                lottoModel.calculateLotto()
                val profit = lottoModel.calculateProfit()

                assertEquals(40001000.0, profit) // 예상 수익률 검사
            },
            //5000원 내고 1등 ,3등
            listOf(1, 2, 3, 4, 5, 6),
            listOf(45, 44, 43, 42, 41, 40),
            listOf(1, 2, 3, 4, 44, 45),
            listOf(45, 44, 43, 42, 41, 40),
            listOf(1, 2, 42, 43, 44, 45),
        )
    }
}
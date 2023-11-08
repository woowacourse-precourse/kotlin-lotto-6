package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("Controller 테스트")
class ControllerTest{

    private val controller = Controller()

    @Test
    @DisplayName("purchaseLotto 함수 - 유효한 입력값일 때")
    fun `purchaseLotto 함수 - 유효한 입력값일 때`() {
        val input = "5000"
        val purchaseCost = controller.purchaseLotto(input)
        assertEquals(purchaseCost, 5)
    }

    @Test
    @DisplayName("purchaseLotto 함수 - 정수가 아닌 입력값일 때")
    fun `purchaseLotto 함수 - 정수가 아닌 입력값일 때`() {
        val input = "abc"
        assertThrows<IllegalArgumentException> {
            controller.purchaseLotto(input)
        }
    }

    @Test
    @DisplayName("purchaseLotto 함수 - 1000 미만의 입력값일 때")
    fun `purchaseLotto 함수 - 1000 미만의 입력값일 때`() {
        val input = "999"
        assertThrows<IllegalArgumentException> {
            controller.purchaseLotto(input)
        }
    }

    @Test
    @DisplayName("createLotteryRandomNumber 함수 - 유효한 입력값일 때")
    fun `createLotteryRandomNumber 함수 - 유효한 입력값일 때`() {
        val purchaseNumber = 5
        val lottery = controller.createLotteryRandomNumber(purchaseNumber)
        assertEquals(lottery.size, purchaseNumber)
    }

    @Test
    @DisplayName("createLottoWinningNumbers 함수 - 유효한 입력값일 때")
    fun `createLottoWinningNumbers 함수 - 유효한 입력값일 때`() {
        val userPickInput = "1,2,3,4,5,6"
        val bonusInput = "7"
        val userWinningNumbers = controller.createLottoWinningNumbers(userPickInput, bonusInput)
        assertEquals(userWinningNumbers.userPickNumbers.size, 6)
        assertEquals(userWinningNumbers.bonusNumber, 7)
    }

    @Test
    @DisplayName("createLottoWinningNumbers 함수 - 잘못된 입력값일 때")
    fun `createLottoWinningNumbers 함수 - 잘못된 입력값일 때`() {
        val userPickInput = "1,2,3,4,5"
        val bonusInput = "abc"
        assertThrows<IllegalArgumentException> {
            controller.createLottoWinningNumbers(userPickInput, bonusInput)
        }
    }

    @Test
    @DisplayName("checkWinningDetails 함수 - LottoResult 목록 반환")
    fun `checkWinningDetails 함수 - LottoResult 목록 반환`() {
        val lottery = listOf(
            Lotto(numbers = listOf(1, 2, 3, 4, 5, 6)),
            Lotto(numbers = listOf(7, 8, 9, 10, 11, 12))
        )
        val userWinningNumbers = UserWinningNumbers(
            userPickNumbers = listOf(1, 2, 3, 4, 5, 7),
            bonusNumber = 10
        )
        val lottoResults = controller.checkWinningDetails(lottery, userWinningNumbers)
        assertEquals(lottoResults.size, 2)
    }

    @Test
    @DisplayName("checkLottoWinType 함수 - LottoWinType 목록 반환")
    fun `checkLottoWinType 함수 - LottoWinType 목록 반환`() {
        val lottoResults = listOf(
            LottoResult(winningCount = 3, bonusJudge = true),
            LottoResult(winningCount = 5, bonusJudge = false),
            LottoResult(winningCount = 0, bonusJudge = true)
        )
        val lottoWinTypes = controller.checkLottoWinType(lottoResults)
        assertEquals(lottoWinTypes.size, 2)
    }

}
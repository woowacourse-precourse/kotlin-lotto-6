package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest : NsTest() {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGame = LottoGame()
    private val hashMap = HashMap<Int, Int>()

    @BeforeEach
    fun hashMapSetting() {
        for(i in 0 until 6) hashMap[i] = 0
        hashMap[1] = 1
    }

    override fun runMain() {
        main()
    }

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
    fun `로또 번호에 1~45 범위 밖의 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }
    @Test
    fun `Exception 및 출력 확인 (구매 금액이 천원 미만인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validatePurchaseAmount("500")
        }
        Assertions.assertSimpleTest {
            runException("500")
            assertThat(output()).contains(ERROR_LESS_THAN_THOUSAND_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (구매 금액이 음수인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validatePurchaseAmount("-1000")
        }
        Assertions.assertSimpleTest {
            runException("-1000")
            assertThat(output()).contains(ERROR_LESS_THAN_THOUSAND_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (구매 금액이 Int 범위를 넘어가는 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validatePurchaseAmount(TEST_OUT_OF_INT)
        }
        Assertions.assertSimpleTest {
            runException(TEST_OUT_OF_INT)
            assertThat(output()).contains(ERROR_UNDEFINED_PRICE_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (구매 금액 입력이 숫자가 아닌 문자인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validatePurchaseAmount("a")
        }
        Assertions.assertSimpleTest {
            runException("a")
            assertThat(output()).contains(ERROR_UNDEFINED_PRICE_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (구매 금액 입력이 null인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validatePurchaseAmount("")
        }
        Assertions.assertSimpleTest {
            runException("\n")
            assertThat(output()).contains(ERROR_INPUT_PRICE_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (당첨 번호 입력에 공백이 있는 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateInputWinningNumber("1,2,3,4,5, 6")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5, 6")
            assertThat(output()).contains(ERROR_CONTAINS_SPACE_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (당첨 번호 입력 숫자가 5개인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateInputWinningNumber("1,2,3,4,5")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5")
            assertThat(output()).contains(ERROR_NEED_SIX_NUMBERS_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (당첨 번호 입력 숫자가 7개인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateInputWinningNumber("1,2,3,4,5,6,7")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5,6,7")
            assertThat(output()).contains(ERROR_NEED_SIX_NUMBERS_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (당첨 번호 입력에 중복된 숫자가 있는 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateInputWinningNumber("1,2,3,4,5,5")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5,5")
            assertThat(output()).contains(ERROR_REDUNDANT_NUMBER_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (당첨 번호 입력에 1~45 범위 밖의 숫자가 있는 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateInputWinningNumber("1,2,3,4,5,46")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5,46")
            assertThat(output()).contains(ERROR_NUMBER_OUT_OF_BOUND_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (당첨 번호 입력에 숫자가 아닌 문자가 있는 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateInputWinningNumber("1,2,3,4,5,a")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5,a")
            assertThat(output()).contains(ERROR_UNDEFINED_NUMBER_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (당첨 번호 입력이 공백인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateInputWinningNumber("")
        }
        Assertions.assertSimpleTest {
            runException("1000", "\n")
            assertThat(output()).contains(ERROR_UNDEFINED_NUMBER_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (보너스 번호 입력이 1~45 범위 밖의 숫자인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateBonusNumber(listOf(1,2,3,4,5,6), "46")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "46")
            assertThat(output()).contains(ERROR_NUMBER_OUT_OF_BOUND_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (보너스 번호 입력이 당첨 번호와 중복되는 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateBonusNumber(listOf(1,2,3,4,5,6), "6")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "6")
            assertThat(output()).contains(ERROR_BONUS_NUMBER_REDUNDANT_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (보너스 번호 입력이 null인 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateBonusNumber(listOf(1,2,3,4,5,6), "")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "\n")
            assertThat(output()).contains(ERROR_UNDEFINED_NUMBER_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `Exception 및 출력 확인 (보너스 번호 입력이 숫자가 아닌 경우)`() {
        assertThrows<IllegalArgumentException> {
            inputView.validateBonusNumber(listOf(1,2,3,4,5,6), "a")
        }
        Assertions.assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "a")
            assertThat(output()).contains(ERROR_UNDEFINED_NUMBER_MENTION)
            assertThat(output()).contains(INPUT_RETRY_MENTION)
        }
    }

    @Test
    fun `로또 구매 수량 출력 확인`() {
        outputView.printPurchaseNumberMention(1)
        assertThat(output()).contains("1개를 구매했습니다.")
    }

    @Test
    fun `로또 오름차순 출력 확인`() {
        val lottoList = listOf(Lotto(listOf(6,5,4,3,2,1)))
        lottoGame.printPurchaseLottoResult(1, lottoList)
        assertThat(output()).contains("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `수익률 출력 확인 (반올림 여부)`() {
        outputView.printProfitRate(3.44)
        assertThat(output()).contains("3.4")
        outputView.printProfitRate(3.45)
        assertThat(output()).contains("3.5")
    }

    @Test
    fun `당첨 등수 출력 확인`() {
        val lottoList = listOf(Lotto(listOf(1,2,3,4,5,6)))
        val testWinningNumberList = listOf(1,2,3,4,5,6)
        val res = lottoGame.getWinningList(lottoList, testWinningNumberList, 45)
        assertThat(res).isEqualTo(hashMap)
    }

    @Test
    fun `결과 출력 확인 (1등 1명인 경우)`() {
        outputView.printWinningStatics(hashMap)
        assertThat(output()).contains("6개 일치 (2,000,000,000원) - 1개")
    }

    @Test
    fun `총 당첨 금액 확인 (1등 1명인 경우)`() {
        val res = lottoGame.getTotalPrice(hashMap)
        assertThat(res).isEqualTo(WinningPrice.FIRST.price.toDouble())
    }

    @Test
    fun `로또와 당첨번호 대조 (1등 1명인 경우)`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumberList = listOf(6,5,4,3,2,1)
        val res = lotto.getMatchNumbers(winningNumberList)
        assertThat(res).isEqualTo(6)
    }

    companion object {
        const val TEST_OUT_OF_INT = "50505050505050"

        const val INPUT_RETRY_MENTION = "다시 입력해주세요"
        const val ERROR_INPUT_PRICE_MENTION = "[ERROR] 금액을 입력해주세요."
        const val ERROR_LESS_THAN_THOUSAND_MENTION = "[ERROR] 1,000원 이상이어야 구매가 가능합니다. (로또 1장 : 1,000원)"
        const val ERROR_UNDEFINED_PRICE_MENTION = "[ERROR] 금액은 숫자만 입력해주셔야하며, Int범위 이내여야합니다. (21억 이하 가능)"
        const val ERROR_CONTAINS_SPACE_MENTION = "[ERROR] 공백없이 입력해주세요."
        const val ERROR_NEED_SIX_NUMBERS_MENTION = "[ERROR] 6개의 숫자를 입력하셔야 합니다."
        const val ERROR_REDUNDANT_NUMBER_MENTION = "[ERROR] 중복되지 않는 6개의 숫자를 입력하셔야 합니다."
        const val ERROR_NUMBER_OUT_OF_BOUND_MENTION = "[ERROR] 1~45 사이의 숫자를 입력하셔야 합니다."
        const val ERROR_UNDEFINED_NUMBER_MENTION = "[ERROR] 숫자를 입력하셔야 합니다."
        const val ERROR_BONUS_NUMBER_REDUNDANT_MENTION = "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다."
    }
}

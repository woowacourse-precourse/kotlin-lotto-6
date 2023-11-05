package lotto

import lotto.controller.LottoController
import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import util.Constants.LOTTO_MAX_NUMBER
import util.Constants.LOTTO_MIN_NUMBER

class LottoTest {
    private val lottoController = LottoController()

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
    fun `로또 구매 개수 일치`() {
        val purchaseAmount = 8000
        val expectNumberOfPurchase = 8

        val actualNumberOfPurchase = lottoController.getNumberOfPurchase(purchaseAmount)

        assertThat(expectNumberOfPurchase).isEqualTo(actualNumberOfPurchase)
    }

    @Test
    fun `로또 구매 개수 불일치`() {
        val purchaseAmount = 8000
        val expectNumberOfPurchase = 9

        val actualNumberOfPurchase = lottoController.getNumberOfPurchase(purchaseAmount)

        assertThat(expectNumberOfPurchase).isNotEqualTo(actualNumberOfPurchase)
    }

    @Test
    fun `로또 번호 생성`() {
        val expectLottoSize = 6

        val lottoNumbers = lottoController.generateLottoNumbers()
        val actualLottoSize = lottoNumbers.size
        val actualLottoSetSize = lottoNumbers.toSet().size

        assertThat(expectLottoSize).isEqualTo(actualLottoSize)
        assertThat(expectLottoSize).isEqualTo(actualLottoSetSize)
        lottoNumbers.forEach { lottoNumber -> assertThat(lottoNumber).isBetween(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER) }
    }

    @Test
    fun `로또 리스트 생성`() {
        val expectNumberOfPurchase = 8

        val lottos = lottoController.makeLottos(expectNumberOfPurchase)
        val actualNumberOfPurchase = lottos.size

        assertThat(expectNumberOfPurchase).isEqualTo(actualNumberOfPurchase)
        lottos.forEach { lotto ->
            lotto.getNumbers().forEach { lottoNumber ->
                assertThat(lottoNumber).isBetween(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            }
        }
    }

    @Test
    fun `로또 당첨 번호 1개 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(6, 7, 8, 9, 10, 11)
        val expectMatchedNumbers = 1

        val actualMatchedNumbers = lottoController.getMatchedNumbers(lotto, winningNumbers)

        assertThat(expectMatchedNumbers).isEqualTo(actualMatchedNumbers)
    }

    @Test
    fun `로또 당첨 번호 2개 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(5, 6, 7, 8, 9, 10)
        val expectMatchedNumbers = 2

        val actualMatchedNumbers = lottoController.getMatchedNumbers(lotto, winningNumbers)

        assertThat(expectMatchedNumbers).isEqualTo(actualMatchedNumbers)
    }

    @Test
    fun `로또 당첨 번호 3개 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(4, 5, 6, 7, 8, 9)
        val expectMatchedNumbers = 3

        val actualMatchedNumbers = lottoController.getMatchedNumbers(lotto, winningNumbers)

        assertThat(expectMatchedNumbers).isEqualTo(actualMatchedNumbers)
    }

    @Test
    fun `로또 당첨 번호 4개 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(3, 4, 5, 6, 7, 8)
        val expectMatchedNumbers = 4

        val actualMatchedNumbers = lottoController.getMatchedNumbers(lotto, winningNumbers)

        assertThat(expectMatchedNumbers).isEqualTo(actualMatchedNumbers)
    }

    @Test
    fun `로또 당첨 번호 5개 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(2, 3, 4, 5, 6, 7)
        val expectMatchedNumbers = 5

        val actualMatchedNumbers = lottoController.getMatchedNumbers(lotto, winningNumbers)

        assertThat(expectMatchedNumbers).isEqualTo(actualMatchedNumbers)
    }

    @Test
    fun `로또 당첨 번호 6개 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val expectMatchedNumbers = 6

        val actualMatchedNumbers = lottoController.getMatchedNumbers(lotto, winningNumbers)

        assertThat(expectMatchedNumbers).isEqualTo(actualMatchedNumbers)
    }

    @Test
    fun `로또 당첨 번호 불일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(7, 8, 9, 10, 11, 12)
        val expectMatchedNumbers = 0

        val actualMatchedNumbers = lottoController.getMatchedNumbers(lotto, winningNumbers)

        assertThat(expectMatchedNumbers).isEqualTo(actualMatchedNumbers)
    }

    @Test
    fun `로또 보너스 번호 일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 4
        val expectBonusMatched = true

        val actualBonusMatched = lottoController.getBonusMatched(lotto, bonusNumber)

        assertThat(expectBonusMatched).isEqualTo(actualBonusMatched)
    }

    @Test
    fun `로또 보너스 번호 불일치`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val expectBonusMatched = false

        val actualBonusMatched = lottoController.getBonusMatched(lotto, bonusNumber)

        assertThat(expectBonusMatched).isEqualTo(actualBonusMatched)
    }

    @Test
    fun `로또 1등 당첨`() {
        val matchedNumbers = 6
        val bonusMatched = false
        val expectWinningRank = 1

        val actualWinningRank = lottoController.judgeWinningRank(matchedNumbers, bonusMatched)

        assertThat(expectWinningRank).isEqualTo(actualWinningRank)
    }

    @Test
    fun `로또 2등 당첨`() {
        val matchedNumbers = 5
        val bonusMatched = true
        val expectWinningRank = 2

        val actualWinningRank = lottoController.judgeWinningRank(matchedNumbers, bonusMatched)

        assertThat(expectWinningRank).isEqualTo(actualWinningRank)
    }

    @Test
    fun `로또 3등 당첨`() {
        val matchedNumbers = 5
        val bonusMatched = false
        val expectWinningRank = 3

        val actualWinningRank = lottoController.judgeWinningRank(matchedNumbers, bonusMatched)

        assertThat(expectWinningRank).isEqualTo(actualWinningRank)
    }

    @Test
    fun `로또 4등 당첨 (보너스 번호 일치)`() {
        val matchedNumbers = 4
        val bonusMatched = true
        val expectWinningRank = 4

        val actualWinningRank = lottoController.judgeWinningRank(matchedNumbers, bonusMatched)

        assertThat(expectWinningRank).isEqualTo(actualWinningRank)
    }

    @Test
    fun `로또 4등 당첨 (보너스 번호 불일치)`() {
        val matchedNumbers = 4
        val bonusMatched = false
        val expectWinningRank = 4

        val actualWinningRank = lottoController.judgeWinningRank(matchedNumbers, bonusMatched)

        assertThat(expectWinningRank).isEqualTo(actualWinningRank)
    }

    @Test
    fun `로또 5등 당첨 (보너스 번호 일치)`() {
        val matchedNumbers = 3
        val bonusMatched = true
        val expectWinningRank = 5

        val actualWinningRank = lottoController.judgeWinningRank(matchedNumbers, bonusMatched)

        assertThat(expectWinningRank).isEqualTo(actualWinningRank)
    }

    @Test
    fun `로또 5등 당첨 (보너스 번호 불일치)`() {
        val matchedNumbers = 3
        val bonusMatched = false
        val expectWinningRank = 5

        val actualWinningRank = lottoController.judgeWinningRank(matchedNumbers, bonusMatched)

        assertThat(expectWinningRank).isEqualTo(actualWinningRank)
    }
}

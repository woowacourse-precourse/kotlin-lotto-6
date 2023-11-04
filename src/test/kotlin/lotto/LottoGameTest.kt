import lotto.domain.LottoGameImpl
import lotto.model.Lotto
import lotto.model.LottoMatchResult
import lotto.model.LottoResult
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoGameTest {
    private lateinit var lottoGame: LottoGameImpl

    @BeforeEach
    fun setUp() {
        lottoGame = LottoGameImpl()
    }

    @Test
    fun `getQuantity - Given 유효한 구매 금액이 주어지면, when 구매할 로또 개수를 생성하는 함수를 호출하면, then 예상 수량을 반환해야 함`() {
        // Given
        val purchaseAmount = 20000
        val expectedQuantity = 20

        // When
        val result = lottoGame.getQuantity(purchaseAmount)

        // Then
        assertThat(result).isEqualTo(expectedQuantity)
    }

    @Test
    fun `createRandomLottoNumbers - Given 유효한 로또 수량이 주어지면, when 로또 랜덤 번호를 생성하는 함수 호출하면, then 주어진 수량의 로또 번호 목록을 반환해야 함`() {
        // Given
        val quantity = 5

        // When
        val result = lottoGame.createRandomLottoNumbers(quantity)

        // Then
        assertThat(result).hasSize(quantity)
    }

    @Test
    fun `getCorrectLottoResults - Given 유효한 로또 번호, 당첨 번호, 보너스 번호가 주어지면, when 로또 결과를 생성하는 함수 호출를 호출하면, then 로또 결과 목록을 반환해야 함`() {
        // Given
        val lottoNumbers = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(2, 3, 4, 5, 6, 7)))
        val winningNumber = Lotto(listOf(2, 3, 4, 5, 6, 7))
        val bonusNumber = 8

        // When
        val result = lottoGame.getLottoResults(lottoNumbers, winningNumber, bonusNumber)

        // Then
        assertThat(result).hasSize(2)
    }

    @Test
    fun `getLottoMatchResult - Given 로또 결과 목록이 주어지면, when 로또 당첨 번호 결과를 생성하는 함수 호출를 호출하면, then 로또 당첨 번호 결과를 반환해야 함`() {
        // Given
        val lottoResults = listOf(LottoResult(6, false), LottoResult(5, true), LottoResult(4, false))
        val expectedResult = LottoMatchResult(sixMatching = 1, fiveMatchingWithBonus = 1, fourMatching = 1)

        // When
        val result = lottoGame.getLottoMatchResult(lottoResults)

        // Then
        assertThat(result).isEqualTo(expectedResult)
    }

}
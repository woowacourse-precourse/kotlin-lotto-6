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

}
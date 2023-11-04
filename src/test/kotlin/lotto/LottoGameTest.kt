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

}
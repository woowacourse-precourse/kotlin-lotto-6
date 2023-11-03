package lotto.model

import lotto.util.LottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTicketTest {
    private val lottoGenerator = LottoGenerator()
    private lateinit var lottoTicket: LottoTicket

    @BeforeEach
    fun setUp() {
        lottoTicket = LottoTicket()
        lottoTicket.addNumbers(lottoGenerator.getSortedNumbers())
        lottoTicket.addNumbers(lottoGenerator.getSortedNumbers())
    }

    @Test
    @DisplayName("로또 번호가 티켓에 잘 들어갔는지 테스트")
    fun addTicketsTest() {
        assertThat(lottoTicket.numbers).hasSize(2)
            .allSatisfy { numbers ->
                assertThat(numbers)
                    .hasSize(6)
                    .doesNotHaveDuplicates()
            }
    }
}
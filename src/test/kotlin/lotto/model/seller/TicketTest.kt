package lotto.model.seller

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

class TicketTest {


    private val testLotto1 = Lotto.of(1, 2, 3, 4, 5, 6)
    private val testLotto2 = Lotto.of(7, 2, 3, 4, 5, 6)

    private val ticket = Ticket(Money(1000))

    @BeforeEach
    fun setupTicket() {
        ticket.record(testLotto1)
    }

    @Test
    fun `로또를 한 개 구매했을 때, 티켓에 로또가 하나 기록되어 있다`() {
        assertThat(ticket.lottoCount).isEqualTo(1)
    }

    @Test
    fun `로또를 한 개 더 구매했을 때, 티켓에 로또가 한 개 더 추가된다`() {
        ticket.record(testLotto2)
        assertThat(ticket.lottoCount).isEqualTo(2)
    }

    @Test
    fun `티켓에 적힌 로또 정보가 처음 생성했던 로또 정보와 동일하다`() {
        val lottos = listOf(testLotto1, testLotto2)
        var index = 0
        ticket.read { lotto ->
            assertThat(lottos[index++].getMatchCount(lotto)).isEqualTo(6)
        }
    }

    @Test
    fun `올바른 형태로 티켓이 출력된다`() {
        val expected1 = "[1, 2, 3, 4, 5, 6]"
        assertThat(ticket.toString()).isEqualTo(expected1)

        ticket.record(testLotto2)
        val expected2 = "$expected1\n[2, 3, 4, 5, 6, 7]"
        assertThat(ticket.toString()).isEqualTo(expected2)
    }
}

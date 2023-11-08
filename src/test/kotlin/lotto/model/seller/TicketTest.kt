package lotto.model.seller

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketTest {

    private val testLotto1 = Lotto.of(1, 2, 3, 4, 5, 6)
    private val testLotto2 = Lotto.of(7, 2, 3, 4, 5, 6)
    private val cost = 1000.toMoney()

    @Test
    fun `로또를 한 개 구매했을 때, 티켓에 로또가 하나 기록되어 있다`() {
        val ticket = Ticket(lottos = listOf(testLotto1), cost = cost)
        assertThat(ticket.lottoCount).isEqualTo(1)
    }

    @Test
    fun `티켓에 적힌 로또 정보가 처음 생성했던 로또 정보와 동일하다`() {
        val lottos = listOf(testLotto1, testLotto2)
        val ticket = Ticket(lottos = lottos, cost = cost)
        var index = 0
        ticket.read { lotto ->
            assertThat(lottos[index++].getMatchCount(lotto)).isEqualTo(6)
        }
    }

    @Test
    fun `올바른 형태로 티켓이 출력된다`() {
        val ticket1 = Ticket(lottos = listOf(testLotto1), cost = cost)
        val expected1 = "[1, 2, 3, 4, 5, 6]"
        assertThat(ticket1.toString()).isEqualTo(expected1)

        val ticket2 = Ticket(lottos = listOf(testLotto1, testLotto2), cost = cost)
        val expected2 = "$expected1\n[2, 3, 4, 5, 6, 7]"
        assertThat(ticket2.toString()).isEqualTo(expected2)
    }
}

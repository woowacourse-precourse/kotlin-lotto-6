package lotto.domain

import lotto.data.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Mockito
import org.mockito.Mockito.mock

class StoreTest {

    private lateinit var mockedIO: IO
    private lateinit var calculator: Calculator
    private lateinit var analyzer: Analyzer
    private lateinit var pos: PointOfSales
    private lateinit var store: Store

    @BeforeEach
    fun setUp() {
        mockedIO = mock(IO::class.java)
        calculator = Calculator()
        analyzer = Analyzer(calculator)
        pos = PointOfSales(analyzer)
        store = Store(mockedIO, calculator, pos)
    }

    @ParameterizedTest(name = "check {0}")
    @MethodSource("generateValidMoneyAndTicketSize")
    @DisplayName("Store : buyLotto() - success")
    fun `로또를 구매하기 위해 1,000원 단위로 지불하면 해당하는 로또를 받는다`(argv: Pair<Int, Int>) {
        // given
        val (money, ticketSize) = argv
        Mockito.`when`(mockedIO.getPurchaseAmount()).thenReturn(money.toUInt())

        // when
        val actual = store.buyLotto()

        // then
        val expected = ticketSize
        assertThat(actual).hasSize(expected)
    }

    @ParameterizedTest(name = "check {0}")
    @ValueSource(ints = [1, 17, 500, 999, 1001, 20_001, 100_001])
    @DisplayName("Store : buyLotto() - fail")
    fun `로또를 구매하기 위해 1,000원 단위로 지불하지 않으면 예외가 발생한다`(paidMoney: Int) {
        // given
        Mockito.`when`(mockedIO.getPurchaseAmount()).thenReturn(paidMoney.toUInt())

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            store.buyLotto()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = Store.SHOULD_BE_NO_CHANGE.format(Lotto.PRICE)
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    companion object {
        @JvmStatic
        fun generateValidMoneyAndTicketSize() = listOf(
            1_000 to 1,
            2_000 to 2,
            37_000 to 37,
            100_000 to 100,
            100_000_000 to 100_000
        )
    }
}
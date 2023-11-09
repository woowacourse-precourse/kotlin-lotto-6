package lotto.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerTest {
    lateinit var customer:Customer

    @BeforeEach
    fun `setUp`(){
        customer = Customer()
    }

    @Test
    fun `로또 1개당 1000원에 구매되지 않으면 예외가 발생한다`(){
        customer.buyLotteries(4000)
        val lottoCount = customer.lotteries.size
        assertEquals(4,lottoCount )
    }

}
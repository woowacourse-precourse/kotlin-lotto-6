package lotto

import lotto.data.ErrorMessage
import lotto.domain.Customer
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomerTest {

    private lateinit var customer: Customer

    private var lottoAmounts = 0



    private var order = 1

    @BeforeEach
    fun setUp() {
        customer = Customer()
        lottoAmounts = 2000

    }

    @Test
    fun `사용자 입력값 적절한지 확인`() {
        val input = "2100"
        val result = customer.checkInputCount(input)

        assertFalse(result)
    }

    @Test
    fun `로또 번호가 입력한 금액에 맞게 생성됐는지 테스트`(){
        customer.produceLottoList()

        val expectedSize = customer.getPurchaseCounts()

        assertEquals(expectedSize, customer.lottoNumsList.size) // getLottoNumsListSize()는 해당 클래스의 public 메서드일 것


    }

}
package lotto.domain.service

import lotto.domain.enum.number.UnitNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoServiceTest {

    val lottoNumberRange = UnitNumber.MIN_LOTTO_NUMBER.number..UnitNumber.MAX_LOTTO_NUMBER.number
    private lateinit var lottoService: LottoService
    @BeforeEach
    fun `setUp`(){
        lottoService = LottoService()
    }
    @Test
    fun `생성한 로또의 숫자들이 1에서 45가 아니라면 오류가 발생 한다`(){
        lottoService.createLotto().getNumbers().forEach { number ->
            assert(lottoNumberRange.contains(number))
        }
    }

    @Test
    fun `생성한 로또의 숫자의 개수가 6개가 아닐 경우 요류가 발생 한다`(){
        val expected = 6
        assertEquals(expected,lottoService.createLotto().getNumbers().size)
    }

}
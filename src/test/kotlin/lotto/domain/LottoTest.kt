package lotto.domain

import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test fun `로또 번호의 개수가 6개보다 적을 경우 예외가 발생한다`(){
        val lottoLengthException = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1,2,3,4,5))
        }
        println(lottoLengthException.message)
    }
    @Test
    fun `로또 번호에 1~45 범위를 벗어나는 숫자가 있으면 예외가 발생한다`(){
        val lowerRangeException = assertThrows<IllegalArgumentException> {
            Lotto(listOf(0,1,2,3,4,5))
        }
        println(lowerRangeException.message)
        val upperRangeException = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1,2,3,4,5,47))
        }
        println(upperRangeException.message)
    }
    @Test
    fun `로또 번호가 오름차순 정렬이 아니라면 예외가 발생한다`(){
        val sortException = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1,3,5,7,9,2))
        }
        println(sortException.message)
    }
}

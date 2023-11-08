package lotto.model

import lotto.model.Bonus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    fun `로또 번호와 보너스 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus(listOf(1, 2, 3, 4, 5, 6),"6")
        }
    }
    @Test
    fun `보너스 번호가 범위(1 -45)를 벗어나면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            Bonus(listOf(1, 2, 3, 4, 5, 6),"47")
        }
    }
    @Test
    fun `보너스 번호가 양수가 아닐시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            Bonus(listOf(1, 2, 3, 4, 5, 6),"-40")
        }
    }
    @Test
    fun `로또 번호를 입력하지 않을시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            Bonus(listOf(1, 2, 3, 4, 5, 6),"")
        }
    }
}
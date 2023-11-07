package lotto.domain


import org.junit.jupiter.api.Test
import lotto.checkValidUserLotto
import org.junit.jupiter.api.assertThrows


class UserLottoTest {
    @Test
    fun `유저 로또 생성시 예외처리 테스트(미달)`() {
        val invalidInput = mutableListOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            checkValidUserLotto(invalidInput)
        }
    }

    @Test
    fun `유저 로또 생성시 예외처리 테스트(초과)`() {
        val invalidInput = mutableListOf(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> {
            checkValidUserLotto(invalidInput)
        }
    }

    @Test
    fun `유저 로또 생성시 예외처리 테스트(중복)`() {
        val invalidInput = mutableListOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> {
            checkValidUserLotto(invalidInput)
        }
    }

    @Test
    fun `유저 로또 생성시 예외처리 테스트(범위)`() {
        val invalidInput = mutableListOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> {
            checkValidUserLotto(invalidInput)
        }
    }


}


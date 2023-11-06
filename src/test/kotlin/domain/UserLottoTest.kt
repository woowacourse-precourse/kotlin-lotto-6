package domain

import lotto.UserLotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserLottoTest {
    @Test
    fun `입력한 번호 예외처리(1~45의 숫자가 아닐경우)`() {
        var userLotto = UserLotto()
        var input = mutableListOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> { userLotto.checkValidUserLotto(input) }
    }

    @Test
    fun `입력한 번호 예외처리(중복되는 숫자가 있을경우)`() {
        var userLotto = UserLotto()
        var input = mutableListOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> { userLotto.checkValidUserLotto(input) }
    }
    @Test
    fun `입력한 번호 예외처리(6개의 숫자가 아닐경우)`() {
        var userLotto = UserLotto()
        var input = mutableListOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> { userLotto.checkValidUserLotto(input) }
    }
}
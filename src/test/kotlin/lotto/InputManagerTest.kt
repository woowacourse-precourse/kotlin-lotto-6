package lotto

import lotto.data.LottoNums
import lotto.domain.Customer
import lotto.domain.LottoInputManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InputManagerTest {


    private lateinit var inputManager: LottoInputManager

    private var lottoNums = LottoNums(emptyList(),0)

    @BeforeEach
    fun setUp(){
        inputManager = LottoInputManager()
    }

    @Test fun `로또 번호 적절히 체크하는지 테스트`(){
        val inputNum = "1,2,3,4,56,7"
        val result= inputManager.checkInputLottoNums(inputNum)

        Assertions.assertFalse(result)

        val inputDuplicatedNum = listOf(1,2,3,4,7,7)
        val secondResult= inputManager.checkDuplicateNums(inputDuplicatedNum)

        Assertions.assertFalse(secondResult)

    }




}
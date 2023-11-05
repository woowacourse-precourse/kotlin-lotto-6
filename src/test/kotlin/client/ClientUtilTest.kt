package client

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class ClientUtilTest {

    @Test
    fun `실수 입력시 에러 확인`() {
        assertThrows<IllegalArgumentException>{
            clientUtil.checkIsInteger("124.2")
        }
    }

    @Test
    fun `1000단위가 아닐때 에러 확인`() {
        assertThrows<IllegalArgumentException>{
            clientUtil.checkNoDividedByThousand(1000300)
        }
    }

    @Test
    fun `로또 당첨 형식 에러 확인`() {
        assertThrows<IllegalArgumentException>{
            clientUtil.checkIsCorrectWinNumber(",23,34,54,23,1")
        }
    }

    @Test
    fun `1부터 45 사이가 아닐경우 에러 확인`() {
        assertThrows<IllegalArgumentException>{
            clientUtil.checkIsCorrectLottoNumber(46)
        }
    }

    @Test
    fun `당첨 번호 중복일 경우 에러 확인`() {
        assertThrows<IllegalArgumentException>{
            clientUtil.checkIsDuplicated(listOf("22","19","31","22","4","5"))
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호에 있을 경우 에러 확인`() {
        assertThrows<IllegalArgumentException>{
            clientUtil.checkIsInWinNumberList(5,listOf(22,19,31,26,4,5))
        }
    }

    companion object{
        val clientUtil = ClientUtil()
    }
}
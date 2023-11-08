package lotto
import camp.nextstep.edu.missionutils.Console

class InPutView {

    fun inputPayment(): Int {
        val purchaseAmount = Console.readLine()
        return purchaseAmount.toInt()
    }

    fun inputLottoNumber(): List<Int> {
        val LottoNumber = Console.readLine()
        val LottoNumberList = LottoNumber.split(",")
        return LottoNumberList.map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        val bonusNumber = Console.readLine()
        return bonusNumber.toInt()
    }
    fun initLottoNumber(lotto : List<Int>,bonus:Int): LottoNumber {
        return LottoNumber(lotto,bonus)
    }
}
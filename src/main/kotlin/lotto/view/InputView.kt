package lotto.view
import camp.nextstep.edu.missionutils.Console
class InputView {

    fun lottoPurchase(): Int{
        return (Console.readLine()).toInt()
    }
    fun inputRightLottoNumber(): List<Int>{
        val rightLottoNumber=Console.readLine()
        return rightLottoNumber.split(",").map { it.toInt() }
    }
    fun inputBonusNumber(): Int{
        return (Console.readLine()).toInt()
    }
}
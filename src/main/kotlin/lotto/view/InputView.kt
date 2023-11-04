package lotto.view
import camp.nextstep.edu.missionutils.Console
class InputView {

    fun lottoPurchase(): Int{
        return (Console.readLine()).toInt()
    }
    fun inputRightLottoNumber(): List<String>{
        val rightLottoNumber=Console.readLine()
        return rightLottoNumber.split(",")
    }
    fun inputBonusNumber(): String{
        return Console.readLine()
    }
}
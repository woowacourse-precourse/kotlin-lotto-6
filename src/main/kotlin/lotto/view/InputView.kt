package lotto.view
import camp.nextstep.edu.missionutils.Console
class InputView {

    fun lottoPurchase(): String {
        return Console.readLine()
    }
    fun inputRightLottoNumber(): List<Int> {
        val rightLottoNumber=Console.readLine()
        return rightLottoNumber.split(",").map{ it.toInt() }
    }
    fun inputBonusNumber(): Int {
        return (Console.readLine()).toInt()
    }
}
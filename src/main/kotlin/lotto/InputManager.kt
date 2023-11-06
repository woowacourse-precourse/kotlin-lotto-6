package lotto
import camp.nextstep.edu.missionutils.Console.readLine
class InputManager {
    val exceptionManager = ExceptionManager()
    fun money() : Int{
        val moneyString = readLine()
        exceptionManager.money(moneyString)
        return moneyString.toInt()
    }
}
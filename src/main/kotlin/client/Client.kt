package client
import camp.nextstep.edu.missionutils.Console
class Client {
    private val util = ClientUtil()
    fun inputBuyMoneyToCount(): Int {
        val input = Console.readLine()
        util.checkIsInteger(input)
        val money = input.toInt()
        util.checkNoDividedByThousand(money)
        return money/1000
    }
}
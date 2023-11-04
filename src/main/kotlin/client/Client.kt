package client

class Client {
    val util = ClientUtil()
    fun inputBuyMoney(): Int {
        val input = readln()
        util.checkIsInteger(input)
        val money = input.toInt()
        util.checkNoDividedByThousand(money)
        return money
    }
}
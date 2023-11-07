package lotto
import camp.nextstep.edu.missionutils.Console

class Ticket() {
    fun inputmoney(): Int {
        val inputMoney = Console.readLine().toIntOrNull()

        if (inputMoney == null) {
            return 0 // Handle invalid input
        } else {
            return inputMoney
        }
    }

    fun inputticket(money: Int): Int {
        val ticketcount = money / 1000
        return ticketcount
    }
}
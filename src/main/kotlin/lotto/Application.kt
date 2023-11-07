package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val ERROR = "[ERROR]"
const val NOT_MULTIPLE_OF_1000_ERROR = " 구입금액은 1000의 배수여야 합니다. 다시 입력해 주세요."

fun main() {
    println("구입금액을 입력해 주세요.")

    val numberOfTickets = getNumberOfTickets( validateInputMoney( getInputMoney() ) )
    println("\n${numberOfTickets}개를 구매했습니다.")


    val tickets = generateAllTickets(numberOfTickets)

    printTickets(tickets)

}

fun getInputMoney(): Int {

    return Console.readLine().toInt()
}

fun checkException(inputMoney: Int) {
    require(inputMoney % 1000 == 0) { throw IllegalArgumentException(ERROR+NOT_MULTIPLE_OF_1000_ERROR) }

}

fun validateInputMoney(inputMoney: Int): Int {
    var isValidInput = false

    while (!isValidInput) {
        try {
            checkException(inputMoney)
            isValidInput = true

        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            getInputMoney()

        }

    }

    return inputMoney
}

fun getNumberOfTickets( inputMoney: Int ): Int{

    return inputMoney / 1000
}

fun generateLottoNumbers(): List<Int> {

    return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted<Int>()
}

fun generateAllTickets(numberOfTickets: Int): List<Lotto> {
    val tickets = mutableListOf<Lotto>()
    repeat (numberOfTickets) {
        val numbers = generateLottoNumbers()
        val aTicket = Lotto(numbers)
        tickets.add(aTicket)

    }

    return tickets
}

fun printTickets(tickets: List<Lotto>) {
    for (aTicket in tickets) {
        println(aTicket)

    }
}
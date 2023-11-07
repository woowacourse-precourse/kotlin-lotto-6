package lotto

import camp.nextstep.edu.missionutils.Console

class LottoProcess {
    fun start() {
        val userCost = payLottery()
        val userTicket = getLottoTickets(userCost)
        val winningNumbers = getWinningNumbers()
    }

    private fun payLottery(): Int {
        println("구입금액을 입력해 주세요.")
        val userPayment = Console.readLine()
        validatePayment(userPayment)
        return userPayment.toInt()
    }

    private fun getLottoTickets(payment: Int): List<Lotto> {
        return LottoMachine(payment).generateLotto()
    }

    private fun printLottoTickets(userTickets: List<Lotto>) {
        for (ticket in userTickets) {
            println("${ticket.getDelimiter()}")
        }
    }
    private fun getWinningNumbers(): WinningNumbers {
        println("당첨 번호를 입력해 주세요.")
        val inputWinningNumber = Console.readLine()
        val winningNumbers = validateNumbersInput(inputWinningNumber)

        return WinningNumbers(winningNumbers)
    }

    private fun validatePayment(userPayment: String): String {
        if (userPayment.isEmpty()) throw IllegalArgumentException("[ERROR] 값을 입력해주세요.")
        if (userPayment.isBlank()) throw IllegalArgumentException("[ERROR] 값을 입력해주세요.")
        if (!userPayment.matches(Regex("^\\d*\$"))) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.")
        }
        if ((userPayment.toInt() % 1000) != 0) throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
        if (userPayment.toInt() < 1000) throw IllegalArgumentException("[ERROR] 최소 1000원 이상 입력해주세요.")
        return userPayment
    }

    private fun validateNumbersInput(inputWinningNumbers: String): List<Int> {
        val inputs = inputWinningNumbers.split(",")
        try {
            return inputs.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.")
        }
    }
}
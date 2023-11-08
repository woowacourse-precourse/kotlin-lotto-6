package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = Console.readLine().toInt()

        if (purchaseAmount < 0) {
            throw IllegalArgumentException("구입금액은 음수가 될 수 없습니다.")
        }

        val lottoGame = LottoGame(purchaseAmount)
        lottoGame.purchaseLottoTickets()

        println("\n${lottoGame.getLottoTickets().size}개를 구매했습니다.")
        lottoGame.getLottoTickets().forEach { println(it.numbers) }

        println("\n당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine()

        val winningNumbersList = winningNumbers.split(",").map { it.trim().toInt() }
        if (winningNumbersList.size != 6 || !winningNumbersList.all { it in 1..45 }) {
            throw IllegalArgumentException("당첨 번호는 1부터 45까지의 서로 다른 6개 숫자여야 합니다.")
        }

        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine()

        val bonusNumberInt = bonusNumber.trim().toInt()
        if (bonusNumberInt !in 1..45 || winningNumbersList.contains(bonusNumberInt)) {
            throw IllegalArgumentException("보너스 번호는 1부터 45까지의 당첨 번호와 겹치지 않는 숫자여야 합니다.")
        }

        val lottoResult = lottoGame.checkResults(winningNumbersList, bonusNumberInt)

        lottoResult.displayResults()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }
}

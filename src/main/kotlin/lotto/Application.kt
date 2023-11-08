package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val user = User()
    user.inputPurchaseMoney()
    user.purchaseLottoTickets()

    var lotto: Lotto
    var validation: Boolean = false
    var winning = listOf<Int>()
    while (!validation) {
        try {
            winning = user.inputLottoNumbers()
            lotto = Lotto(winning)
            validation = true
        } catch (e: IllegalArgumentException){
            println("[ERROR] ${e.message}")
        }
    }
    user.inputBonusNumber()
    val winningNumbers = lotto.getWinningNumbers()

    Statistics.howManyWins(lotto.getWinningNumbers(), user)

}

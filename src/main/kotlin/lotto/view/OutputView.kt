package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningRank

class OutputView {

    fun printAskPurchaseMoney() {
        println(INPUT_MONEY_MESSAGE)
    }

    fun printPurchaseLottoQuantity(quantity: Int) {
        println("$quantity$PURCHASE_LOTTO_QUANTITY_MESSAGE")
    }

    fun printLotto(lotto: List<Lotto>) {
        lotto.forEach {
            println("[${it.joinToString(", ")}]")
        }
    }

    fun printAskWinningNumber() {
        println(INPUT_WINNING_NUMBERS_MESSAGE)
    }

    fun printAskBonusNumber() {
        println(INPUT_BONUS_NUMBER)
    }

    fun printRank(rank: Map<WinningRank, Int>) {
        println(WINNING_RANK_MESSAGE)
        println(SEPARATOR)
        rank.forEach {
            println("${it.key.message} (${it.key.winningPrize}원) - ${it.value}개")
        }
    }

    companion object {
        private const val INPUT_MONEY_MESSAGE = "구입 금액을 입력해 주세요."
        private const val PURCHASE_LOTTO_QUANTITY_MESSAGE= "개를 구매했습니다."
        private const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        private const val WINNING_RANK_MESSAGE = "당첨 통계"
        private const val SEPARATOR = "---"
    }

}
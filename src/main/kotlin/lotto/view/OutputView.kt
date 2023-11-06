package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningRank

class OutputView {

    fun printPurchaseMoney() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchaseLottoQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun printLotto(lotto: List<Lotto>) {
        lotto.forEach {
            println("[${it.joinToString(", ")}]")
        }
    }

    fun printRank(rank: Map<WinningRank, Int>) {
        rank.forEach {
            println("${it.key.message} (${it.key.winningPrize}원) - ${it.value}개")
        }
    }

}
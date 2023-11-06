package lotto.view

import lotto.domain.Lotto

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

}
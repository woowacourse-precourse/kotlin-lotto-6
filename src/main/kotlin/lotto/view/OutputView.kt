package lotto.view

import lotto.model.Lottos

class OutputView {
    fun printPurchaseResults(lottos: Lottos) {
        println()

        println(PURCHASE_COUNT_CONFIRMATION.format(
            lottos.lottoNumbers.size
        ))

        println(lottos)
    }

    companion object {
        const val PURCHASE_COUNT_CONFIRMATION = "%d개를 구매했습니다."
    }
}
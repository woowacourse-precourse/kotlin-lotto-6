package lotto.view

import lotto.model.Lottos

class OutputView {
    fun printPurchaseResults(lottos: Lottos) {
        println(PURCHASE_COUNT_CONFIRMATION.format(
            lottos.lottoNumbers.size
        ))

        println("${lottos}\n")
    }

    fun printWinnigResults() {
        println(
            """
                당첨 통계
                ---
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
            """.trimIndent()
        )

    }

    fun printError(errorMessage: String) = println("$ERROR_TAG $errorMessage")

    companion object {
        const val PURCHASE_COUNT_CONFIRMATION = "%d개를 구매했습니다."
        const val ERROR_TAG = "[ERROR]"
    }
}
package lotto.view

import lotto.model.Lotto
import lotto.model.WinningRank

class OutputView {
    fun purchasePrompt() = println(PURCHASE_PROMPT)

    fun lottoNumbersPrompt(count: Int) = println("\n$count$LOTTO_COUNT_PROMPT")

    fun inputLottoNumbersPrompt() = println("\n$INPUT_LOTTO_NUMBERS_PROMPT")

    fun lottoNumbers(lottoes: List<Lotto>) = lottoes.forEach {
        println(it.toString())
    }

    fun inputBonusNumberPrompt() = println("\n$INPUT_BONUS_NUMBER_PROMPT")

    fun winningResultPrompt() = print(WINNING_RESULT_PROMPT)

    fun winningResult(lottoesResult: Map<WinningRank, Int>) {
        println(
            """
                ${WinningRank.FIFTH.content}$HYPHEN${lottoesResult[WinningRank.FIFTH]}$COUNT_DESCRIPTION
                ${WinningRank.FOURTH.content}$HYPHEN${lottoesResult[WinningRank.FOURTH]}$COUNT_DESCRIPTION
                ${WinningRank.THIRD.content}$HYPHEN${lottoesResult[WinningRank.THIRD]}$COUNT_DESCRIPTION
                ${WinningRank.SECOND.content}$HYPHEN${lottoesResult[WinningRank.SECOND]}$COUNT_DESCRIPTION
                ${WinningRank.FIRST.content}$HYPHEN${lottoesResult[WinningRank.FIRST]}$COUNT_DESCRIPTION
            """.trimIndent()
        )
    }

    fun totalProfitRate(profitRate: Double) =
        println("$PROFIT_RATE_DESCRIPTION $profitRate$PERCENTAGE")

    companion object {
        const val PURCHASE_PROMPT = "구입 금액을 입력해주세요."
        const val LOTTO_COUNT_PROMPT = "개를 구매했습니다."
        const val INPUT_LOTTO_NUMBERS_PROMPT = "당첨 번호를 입력해주세요."
        const val INPUT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
        const val WINNING_RESULT_PROMPT = """
당첨 통계
---
"""
        const val HYPHEN = " - "
        const val COUNT_DESCRIPTION = "개"
        const val PROFIT_RATE_DESCRIPTION = "총 수익률은"
        const val PERCENTAGE = "%입니다."
    }

}
package lotto.view

class OutputView {
    fun lottoNumbers() {

    }

    fun winningResult() {

    }

    fun totalProfitRate() {

    }

    fun purchasePrompt() = println(PURCHASE_PROMPT)


    fun inputLottoNumbersPrompt() = println(INPUT_LOTTO_NUMBERS_PROMPT)

    fun winningResultPrompt() = println(WINNING_RESULT_PROMPT)

    fun inputBonusNumberPrompt() = println(INPUT_BONUS_NUMBER_PROMPT)

    companion object {
        const val PURCHASE_PROMPT = "구입 금액을 입력해주세요."
        const val INPUT_LOTTO_NUMBERS_PROMPT = "당첨 번호를 입력해주세요."
        const val INPUT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
        const val WINNING_RESULT_PROMPT = """
당첨 통계
---
        """
    }

}
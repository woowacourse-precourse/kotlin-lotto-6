package lotto

enum class PrintMessage(private val messageTemplate: (Int?) -> String) {
    INPUT_AMOUNT({ _ -> "구입금액을 입력해 주세요." }),
    INPUT_PRICE({ count -> "\n${count ?: ""}개를 구매했습니다.\n" }),
    INPUT_WINNING_NUMBER({"\n당첨 번호를 입력해 주세요."}),
    INPUT_BONUS_NUMBER({"\n보너스 번호를 입력해 주세요."}),
    OUTPUT_WINNING_STATISTICS({"\n당첨 통계\n---"}),;

    fun content(count: Int? = null) = messageTemplate(count)
}
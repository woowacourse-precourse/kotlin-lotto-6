package lotto.domain.enum.notice

enum class Guide(val notice:String) {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계")
}


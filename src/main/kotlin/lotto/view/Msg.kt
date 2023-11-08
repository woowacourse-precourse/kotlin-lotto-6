package lotto.view

enum class Msg(val msg: String) {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_LOTTO_NUMBER("개를 구매했습니다."),
    OUTPUT_WINNING_STATUS("당첨 통계\n---"),
    OUTPUT_THREE_CORRECT("3개 일치 (5,000원) - "),
    OUTPUT_FOUR_CORRECT("4개 일치 (50,000원) - "),
    OUTPUT_FIVE_CORRECT("5개 일치 (1,500,000원) - "),
    OUTPUT_FIVE_BOUNUS_CORRECT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    OUTPUT_SIX_CORRECT("6개 일치 (2,000,000,000원) - "),
    OUTPUT_RATE_RETURN("총 수익률은 ")
}
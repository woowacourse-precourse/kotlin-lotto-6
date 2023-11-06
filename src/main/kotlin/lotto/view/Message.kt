package lotto.view

enum class Message(val message: String) {
    REQUEST_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    PURCHASED_LOTTO_COUNT("개를 구매했습니다."),

    WINNING_STATISTICS("당첨 통계"),

    SEPARATION_LINE("---"),

    OUTPUT_TOTAL_ROI("총 수익률은 "),

    ERROR_PURCHASE_PRICE("[ERROR] 구매 금액은 1000원 단위의 정수만 입력합니다"),
    ERROR_INT("[ERROR] 숫자를 입력해주세요."),
    ERROR_NUMBER_RANGE("[ERROR] ,를 기준으로 작성해주시고, 로또 번호의 숫자 범위는 1~45까지입니다."),
    ERROR_SIX_DIFFERENT_NUMBERS("[ERROR] ,를 기준으로 서로 다른 6개의 숫자를 넣어주셔야 합니다.")
}
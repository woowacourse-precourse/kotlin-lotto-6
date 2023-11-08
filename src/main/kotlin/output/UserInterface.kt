package output

enum class UserInterface(
    val mention: String
) {
    //예외 처리 노출 문구
    UNDER_AND_OVER_NUMBER_EXCEPTION("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_INPUT_SAME_NUMBER_EXCEPTION("[ERROR] 당첨 번호에 동일한 숫자를 입력할 수 없습니다."),
    NOT_INPUT_SPACE_EXCEPTION("[ERROR] 당첨 번호는 공백이 입력될 수 없습니다."),
    INPUT_IN_UNIT_OF_THOUSANDS_EXCEPTION("[ERROR] 로또 구매 금액은 1,000원 단위로 입력 되어야 합니다."),
    INPUT_WINNING_NUMBER_SIZE_NOT_6_EXCEPTION("[ERROR] 당첨 번호는 6개만 입력할 수 있습니다."),
    INPUT_BONUS_NUMBER_SIZE_NOT_1_EXCEPTION("[ERROR] 보너스 번호는 1개만 입력할 수 있습니디."),
    INPUT_NOT_STRING("[ERROR] 숫자만 입력해야 합니다."),

    //UI
    INPUT_USER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_USER_PURCHASE_RESULT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_RESULT("당첨 통계 \n ---"),

}
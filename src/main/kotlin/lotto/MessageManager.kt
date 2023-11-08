package lotto


enum class MessageManager(val mes: String) {
    COMMENTS_HOW_MUCH_BUY("구입금액을 입력해 주세요."),
    COMMENTS_MAIN_NUMBER("당첨 번호를 입력해 주세요."),
    COMMENTS_SUB_NUMBER("보너스 번호를 입력해 주세요."),
    COMMENTS_LOTTO_RESULT("당첨 통계\n" + "---");
}
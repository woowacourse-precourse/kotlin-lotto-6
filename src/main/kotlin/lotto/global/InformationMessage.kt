package lotto.global

enum class InformationMessage(val message: String) {
	PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
	PURCHASE_SUCCESS("개를 구매했습니다."),
	WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	WINNING_STATISTIC("당첨 통계\n---");

	fun place(numbers: Array<Int>) = "$message\n" +
			"3개 일치 (5,000원) - ${numbers[0]}개\n" +
			"4개 일치 (50,000원) - ${numbers[1]}개\n" +
			"5개 일치 (1,500,000원) - ${numbers[2]}개\n" +
			"5개 일치, 보너스 볼 일치 (30,000,000원) - ${numbers[3]}개\n" +
			"6개 일치 (2,000,000,000원) - ${numbers[4]}개"
}
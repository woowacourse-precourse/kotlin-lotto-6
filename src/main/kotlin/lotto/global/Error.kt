package lotto.global

enum class Error(val message: String) {
	PURCHASE_AMOUNT("1,000원 단위의 숫자를 입력해주세요"),
	NOT_NUMBER("숫자를 입력해주세요"),
	NUMBER_RANGE("1~${Config.LOTTO_RANGE.value}의 숫자만 입력해주세요"),
	NUMBER_NUMBER("${Config.NUMBER_DRAW.value}개의 숫자를 입력해주세요"),
	WINNING_STATISTIC("당첨 통계\n---");

	fun message() = "[ERROR] $message"
}
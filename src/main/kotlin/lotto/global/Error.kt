package lotto.global

enum class Error(val message: String) {
	PURCHASE_AMOUNT("${Config.LOTTO_PRICE}원 단위의 숫자를 입력해주세요"),
	NOT_NUMBER("숫자를 입력해주세요"),
	NUMBER_RANGE("1~${Config.LOTTO_RANGE}의 숫자만 입력해주세요"),
	NUMBER_NUMBER("${Config.NUMBER_DRAW}개의 숫자를 입력해주세요");

	fun message() = "[ERROR] $message"
}
package lotto.exception

enum class LottoShopException(val message: String) {
    NOT_DIVISIBLE_WITH_LOTTO_PRICE("[ERROR] 구입금액은 %d원 단위로 입력해야 합니다."),
    NOT_ENOUGH_MONEY("[ERROR] 구입금액은 최소 %d원 이상 입력해야 합니다.");

    fun getLottoPrice(price: Int): String = message.format(price)
}
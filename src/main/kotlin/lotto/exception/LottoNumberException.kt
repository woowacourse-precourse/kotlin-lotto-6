package lotto.exception

enum class LottoNumberException(val message: String) {
    OUT_RANGE("[ERROR] 로또 숫자 범위는 %d부터 %d까지 입니다.");

    fun getLottoNumberRange(min: Int, max: Int): String = message.format(min, max)
}
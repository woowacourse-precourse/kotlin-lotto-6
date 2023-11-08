package lotto.exception

enum class LottoNumberException(val message: String) {
    OUT_RANGE("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.");

    fun getLottoNumberRange(min: Int, max: Int): String = message.format(min, max)
}
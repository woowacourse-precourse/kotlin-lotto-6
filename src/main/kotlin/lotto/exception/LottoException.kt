package lotto.exception

enum class LottoException(val message: String) {
    NUMBER_SIZE_NOT_MATCH("[ERROR] 로또 번호는 총 %d개가 필요합니다."),
    DUPLICATE_NUMBER_EXIST("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");

    fun getLottoSize(size: Int): String = message.format(size)
}
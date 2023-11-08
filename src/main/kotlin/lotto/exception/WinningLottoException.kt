package lotto.exception

enum class WinningLottoException(val message: String) {
    BONUS_NUMBER_DUPLICATED("[ERROR] 보너스 번호가 로또 번호와 중복됩니다.")
}
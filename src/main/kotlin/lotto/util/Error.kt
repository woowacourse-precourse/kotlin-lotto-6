package lotto.util

enum class Error(val message: String) {
    NotNumber("[ERROR] 숫자를 입력해 주세요."),
    InvalidUnit("[ERROR] 1000원 단위로 입력해 주세요."),
    InvalidLottoNumberCount("[ERROR] 로또 번호는 6개로 이루어져야 합니다."),
    InvalidLottoNumber("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    InvalidBonusNumber("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."),
    HasDuplicateLottoNumber("[ERROR] 로또 번호는 중복될 수 없습니다."),
}
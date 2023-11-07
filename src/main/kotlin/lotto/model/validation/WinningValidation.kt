package lotto.model.validation

class WinningValidation(
    winningNumbers: List<LottoNumber>,
    bonusNumber: LottoNumber,
) {
    init {
        require(winningNumbers.contains(bonusNumber).not()) {
            "보너스 번호는 로또 번호와 중복될 수 없습니다."
        }
    }
}
package lotto

class LottoGameView {

    fun startInputLottoMoney() {
        println(INPUT_MONEY)
    }

    fun inputUserLottoNumber() {
        println(INPUT_LOTTO_NUMBERS)
    }

    fun inputBonusNumber() {
        println(INPUT_BONUS)
    }

    companion object {
        private const val INPUT_MONEY = "구입 금액을 입력해주세요"
        private const val INPUT_LOTTO_NUMBERS = "당첨번호를 입력해주세요"
        private const val INPUT_BONUS = "보너스 번호를 입력해주세요"
    }
}
package lotto.exception

class LottoValidation(private val lotto: String) {
    private val input: List<String> = lotto.split(",")

    init {
        validateLottoComma()
        validateLottoRange()
        validateLottoNumber()
        validateLottoDuplication()
        validateLottoSix()
    }

    private fun validateLottoComma() {
        require(lotto.contains(",")) {
            "[ERROR] 번호를 쉼표 기준으로 입력해주세요."
        }
    }

    private fun validateLottoRange() {
        repeat(input.size) {
            require(input[it].toInt() in 1..45) {
                "[ERROR] 1~45 사이의 숫자만 가능합니다."
            }
        }
    }

    private fun validateLottoNumber() {
        repeat(input.size) {
            val length = input[it].length
            require(input[it].matches(Regex("[0-9]{$length}"))) {
                "[ERROR] 숫자만 입력해주세요."
            }
        }
    }

    private fun validateLottoDuplication() {
        require(input.toSet().size == input.size) {
            "[ERROR] 중복된 숫자는 입력할 수 없습니다."
        }
    }

    private fun validateLottoSix() {
        require(input.size == 6) {
            "[ERROR] 로또 숫자는 6개를 입력해야 합니다."
        }
    }
}
package lotto

import camp.nextstep.edu.missionutils.Console

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoNumbers()
    }

    private fun validateLottoNumbers(): Boolean {
        require(numbers.size == 6) {
            printErrorMessage(ERROR_LOTTO_NUMBER_SIZE_IS_NOT_SIX)
            return false
        }
        require(numbers.distinct().size == 6) {
            printErrorMessage(ERROR_LOTTO_NUMBER_CANT_DUPLICATE)
            return false
        }
        return true
    }

    private fun printErrorMessage(msg: String) {
        println(ERROR_MESSAGE_HEADER + msg)
    }
}

const val MAX_LOTTO_NUMBER = 45
const val MIN_LOTTO_NUMBER = 1
const val ERROR_MESSAGE_HEADER = "[ERROR] "
const val ERROR_LOTTO_NUMBER_SIZE_IS_NOT_SIX = "로또 당첨 번호는 6개의 정수여야 합니다."
const val ERROR_LOTTO_NUMBER_TYPE_IS_NOT_INT = "로또 당첨 번호의 타입은 정수여야 합니다."
const val ERROR_LOTTO_NUMBER_IS_OUT_OF_RANGE = "로또 당첨 번호는 1~45사이의 정수여야 합니다."
const val ERROR_LOTTO_NUMBER_CANT_DUPLICATE = "로또 당첨 번호는 중복될 수 없습니다."
const val LOTTO_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
const val BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."
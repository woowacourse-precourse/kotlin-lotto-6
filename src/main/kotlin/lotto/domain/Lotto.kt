package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT){
            "[ERROR] 로또 번호로 중복된 숫자는 입력할 수 없습니다."
        }
    }

    companion object {
        val LOTTO_NUMBER_COUNT = 6
    }
}

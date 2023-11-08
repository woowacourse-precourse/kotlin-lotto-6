package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "[ERROR] 6개의 숫자만 입력해주세요"
        }

        require(numbers.toSet().size == numbers.size) {
            "[ERROR] 서로 다른 숫자를 입력해주세요."
        }
    }

}

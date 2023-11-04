package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {"6개의 숫자를 입력해주세요."}
    }

    // TODO: 추가 기능 구현
}

package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호의 개수는 6개여야 합니다." }
        require(numbers.toSet().size == numbers.size) { "로또 번호에 중복된 숫자가 있습니다." }
    }

    // TODO: 추가 기능 구현
}

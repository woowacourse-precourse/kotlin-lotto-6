package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 하나의 로또 당 6개의 숫자가 선택 되어야 합니다." }
        require(numbers.max() <= 45 && numbers.min() >= 1) { "[ERROR] 각 숫자는 1 이상 45 이하여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 한 로또에 선택된 숫자는 중복될 수 없습니다. "}
    }
}

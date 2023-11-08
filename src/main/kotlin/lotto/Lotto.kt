package lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개 입력해야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 중복된 숫자는 입력할 수 없습니다." }
    }
}
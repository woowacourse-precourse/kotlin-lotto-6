package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR]: 번호를 6개만 입력해주세요" }
        require(numbers.distinct().size == 6) { "[ERROR]: 중복된 번호가 있습니다." }
        numbers.forEach {
            require(it in 1..45) { "[ERROR]: 1부터 45 사이의 수를 입력해주세요." }
        }
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }
}

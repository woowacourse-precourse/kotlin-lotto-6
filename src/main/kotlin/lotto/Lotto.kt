package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        // 로또 번호의 개수는 6개여야 한다.
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        // 로또 번호는 1부터 45 사이의 정수여야 한다.
        require(inCorrectRange(numbers)) { "로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        // 로또 번호는 중복이 없어야 한다.
        require(hasDuplicateNumbers(numbers)) { "로또 번호는 중복되지 않아야 합니다." }
    }

    private fun inCorrectRange(lottoNumbers: List<Int>): Boolean {
        for (number in lottoNumbers) {
            if (number !in 1..45) {
                return false
            }
        }
        return true
    }

    private fun hasDuplicateNumbers(lottoNumbers: List<Int>): Boolean {
        val validator = mutableListOf<Int>()
        for (lotto in lottoNumbers) {
            if (validator.contains(lotto.toInt())) {
                return false
            }
            validator.add(lotto.toInt())
        }
        return true
    }
}

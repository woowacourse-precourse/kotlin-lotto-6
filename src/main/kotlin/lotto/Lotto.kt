package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    private fun sortLotto(): List<Int> {
        return numbers.sorted()
    }

    fun compareLottoNumber(lottoNumber: List<Int>): Int {
        return numbers.intersect(lottoNumber.toSet()).size
    }

    fun containBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun printLotto() {
        println("${sortLotto()}")
    }
}

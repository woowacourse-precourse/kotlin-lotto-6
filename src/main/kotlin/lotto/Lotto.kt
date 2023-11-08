package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        LottoData.lottoNumber.add(numbers)
    }

    fun printLottoNumber() {
        val lottoNumberToString = numbers.sorted().joinToString(prefix = "[", postfix = "]") { it.toString() }
        println(lottoNumberToString)
    }
}

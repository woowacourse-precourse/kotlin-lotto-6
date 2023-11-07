package lotto
import java.util.Collections

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        LottoData.lottoNums.add(numbers)
    }

    fun printNumbers(){

        val formattedString = numbers.sorted().joinToString(prefix = "[", postfix = "]") { it.toString() }
        println(formattedString)

    }


}

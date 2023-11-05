package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
    }

    val getNumber: List<Int>
        get() = numbers

}
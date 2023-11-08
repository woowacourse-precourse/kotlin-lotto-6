package lotto.domain.fake

import lotto.domain.NumberGenerator

class FakeNumberGenerator(private val numberSize: Int) : NumberGenerator {
    override fun generateNumbers(): List<Int> {
        val numberList: MutableList<Int> = mutableListOf()
        repeat(numberSize) {
            numberList.add(it)
        }
        return numberList
    }
}
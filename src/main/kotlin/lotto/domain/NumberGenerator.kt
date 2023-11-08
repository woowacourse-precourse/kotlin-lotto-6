package lotto.domain

interface NumberGenerator {
    fun generateNumbers() : List<Int>
}
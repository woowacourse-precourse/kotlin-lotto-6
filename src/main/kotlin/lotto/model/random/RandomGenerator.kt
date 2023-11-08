package lotto.model.random

fun interface RandomGenerator {

    fun pickUniqueNumberInRange(start: Int, end: Int, size: Int): List<Int>
}
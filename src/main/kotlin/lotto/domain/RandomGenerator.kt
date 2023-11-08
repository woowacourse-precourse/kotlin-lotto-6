package lotto.domain

interface RandomGenerator {
    fun pickNumberInRange(startNum: Int, endNum: Int, size: Int): List<Int>
}
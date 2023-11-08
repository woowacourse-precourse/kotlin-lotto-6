package lotto.data.datasource

fun interface RandomNumberDataSource {
    fun pickUniqueNumbersInRange(startInclusive: Int, endInclusive: Int, count: Int): List<Int>
}
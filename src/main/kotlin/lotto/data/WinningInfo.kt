package lotto.data

data class WinningInfo(
    val first: Int,
    val second: Int,
    val third: Int,
    val fourth: Int,
    val fifth: Int,
) {

    override fun toString(): String {
        return """${GRADE.FIVE.countOfSame}개 일치 (${GRADE.FIVE.priceAsString()}) - ${fifth}개
            ${GRADE.FOUR.countOfSame}개 일치 (${GRADE.FOUR.priceAsString()}) - ${fourth}개
            ${GRADE.THREE.countOfSame}개 일치 (${GRADE.THREE.priceAsString()}) - ${third}개
            ${GRADE.TWO.countOfSame}개 일치, 보너스 볼 일치 (${GRADE.TWO.priceAsString()}) - ${second}개
            ${GRADE.ONE.countOfSame}개 일치 (${GRADE.ONE.priceAsString()}) - ${first}개""".trimIndent()
    }

    companion object {
        private const val SHOULD_FIT_SIZE = "[ERROR] 데이터 크기가 맞지 않습니다."
        private const val SHOULD_BE_MORE_THEN_OR_EQUAL_ZERO = "[ERROR] 각 횟수는 0보다 커야 합니다."

        fun from(counts: List<Int>): WinningInfo {
            require(counts.size == GRADE.entries.size) {
                SHOULD_FIT_SIZE
            }
            require(counts.all { it >= 0 }) {
                SHOULD_BE_MORE_THEN_OR_EQUAL_ZERO
            }
            return WinningInfo(
                first = counts[GRADE.ONE.rank().index],
                second = counts[GRADE.TWO.rank().index],
                third = counts[GRADE.THREE.rank().index],
                fourth = counts[GRADE.FOUR.rank().index],
                fifth = counts[GRADE.FIVE.rank().index],
            )
        }
    }
}

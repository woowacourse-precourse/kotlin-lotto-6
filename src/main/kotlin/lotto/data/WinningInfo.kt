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
        private const val SHOULD__FIT_SIZE = "[ERROR] 데이터 크기가 맞지 않습니다."

        fun from(counts: List<Int>): WinningInfo {
            require(counts.size == GRADE.entries.size) {
                SHOULD__FIT_SIZE
            }
            return WinningInfo(
                first = counts[GRADE.ONE.rank()],
                second = counts[GRADE.TWO.rank()],
                third = counts[GRADE.THREE.rank()],
                fourth = counts[GRADE.FOUR.rank()],
                fifth = counts[GRADE.FIVE.rank()],
            )
        }
    }
}

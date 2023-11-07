package lotto.data

data class Stats(
    val first: Int,
    val second: Int,
    val third: Int,
    val fourth: Int,
    val fifth: Int,
    val profitRate: Float,
) {
    override fun toString(): String {
        return """
            ${GRADE.FIVE.countOfSame}개 일치 (${GRADE.FIVE.priceAsString()}) - ${fifth}개
            ${GRADE.FOUR.countOfSame}개 일치 (${GRADE.FOUR.priceAsString()}) - ${fourth}개
            ${GRADE.THREE.countOfSame}개 일치 (${GRADE.THREE.priceAsString()}) - ${third}개
            ${GRADE.TWO.countOfSame}개 일치, 보너스 볼 일치 (${GRADE.TWO.priceAsString()}) - ${second}개
            ${GRADE.ONE.countOfSame}개 일치 (${GRADE.ONE.priceAsString()}) - ${first}개
            총 수익률은 $profitRate%입니다.
        """.trimIndent()
    }
}

package lotto.domain

enum class GameResult(
    val matchNumber: Int,
    val price: Int,
    private val comment: String,
) {
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    fun getResultComment(count: Int): String = "${this.comment} - ${count}개"
}
package lotto.domain

private const val NO_PRICE = 0
private const val FIFTH_PRICE = 5000
private const val FOURTH_PRICE = 50000
private const val THIRD_PRICE = 1500000
private const val SECOND_PRICE = 30000000
private const val FIRST_PRICE = 2000000000

enum class WinningRank(
    val message: String,
    val winningPrize: Int
) {

    NO_MATCHES("2개 이하 일치", NO_PRICE),
    THREE_MATCHES("3개 일치", FIFTH_PRICE),
    FOUR_MATCHES("4개 일치", FOURTH_PRICE),
    FIVE_MATCHES("5개 일치", THIRD_PRICE),
    FIVE_MATCHES_WITH_BONUS_NUMBER("5개 일치, 보너스 볼 일치", SECOND_PRICE),
    SIX_MATCHES("6개 일치", FIRST_PRICE);

}
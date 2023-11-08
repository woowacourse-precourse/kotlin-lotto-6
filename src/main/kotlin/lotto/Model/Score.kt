package lotto.Model

enum class Score(val message: String, val matchNumber: Int, val score: Int) {
    THREE("3개 일치 (5,000원) - ", 3, 5000),
    FOUR("4개 일치 (50,000원) - ", 4, 50000),
    FIVE("5개 일치 (1,500,000원) - ", 5, 1500000),
    FIVEWITHBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 5, 30000000),
    SIX("6개 일치 (2,000,000,000원) - ", 6, 2000000000)
}
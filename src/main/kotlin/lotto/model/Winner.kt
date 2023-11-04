package lotto.model

enum class Winner(val message: String, val correspondNumber: Int, val prize: Int) {
    FIFTH_GRADE("3개 일치 (5,000원) - ", 3, 5000),
    FOURTH_GRADE("4개 일치 (50,000원) - ", 4, 50000),
    THIRD_GRADE("5개 일치 (1,500,000원) - ", 5, 1500000),
    SECOND_GRADE("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 5, 30000000),
    FIRST_GRADE("6개 일치 (2,000,000,000원) - ", 6, 2000000000),
}
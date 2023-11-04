package lotto.model

enum class Winner(message: String, grade: Int) {
    FIRST_GRADE("6개 일치 (2,000,000,000원) - ", 1),
    SECOND_GRADE("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 2),
    THIRD_GRADE("5개 일치 (1,500,000원) - ", 3),
    FOURTH_GRADE("4개 일치 (50,000원) - ", 4),
    FIFTH_GRADE("3개 일치 (5,000원) - ", 5)
}
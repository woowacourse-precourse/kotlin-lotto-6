package output

enum class CompareResult(
    var mention: String
) {
    RESULT_OF_FIFTH_5("3개 일치 (5,000원) - "),
    RESULT_OF_FOURTH_4("4개 일치 (50,000원) - "),
    RESULT_OF_THIRD_3("5개 일치 (1,500,000원) - "),
    RESULT_OF_SECOND_2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RESULT_OF_FIRST_1("6개 일치 (2,000,000,000원) - ")
}
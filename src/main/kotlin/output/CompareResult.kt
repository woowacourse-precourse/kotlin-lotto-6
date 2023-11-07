package output

enum class CompareResult (
    var mention : String
){
    RESULT_OF_FIRST_1("당첨 번호 6개 일치 : 1등(2,000,000,000원) - "),
    RESULT_OF_SECOND_2("당첨 번호 5개 + 보너스 번호 일치 : 2등(30,000,000원) - "),
    RESULT_OF_THIRD_3("당첨 번호 5개 일치 : 3등(1,500,000원) - "),
    RESULT_OF_FOURTH_4("당첨 번호 4개 일치 : 4등(50,000원) - "),
    RESULT_OF_FIFTH_5("당첨 번호 3개 일치 : 5등(5,000원) - ")
}
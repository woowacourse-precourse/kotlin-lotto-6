package lotto

class Result {
    fun statistic() {

    }

    fun printResult() {

        println("""
            당첨 통계
            ---
            3개 일치 (5,000원) - ${}개
            4개 일치 (50,000원) - ${}개
            5개 일치 (1,500,000원) - ${}개
            5개 일치, 보너스 볼 일치 (30,000,000원) - ${}개
            6개 일치 (2,000,000,000원) - ${}개
            총 수익률은 ${}%입니다.
        """.trimIndent())
    }
}
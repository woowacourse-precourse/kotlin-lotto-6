package lottoView

class LottoWinningStatics {
    enum class NumberOfMatches(val message:String){
        THREE_MATCHES("3개 일치 (5,000원) - %d개"),
        FOUR_MATCHES("4개 일치 (50,000원) - %d개"),
        FIVE_MATCHES("5개 일치 (1,500,000원) - %d개"),
        FIVE_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
        SIX_MATHCES("6개 일치 (2,000,000,000원) - %d개"),
        RESULT_RATE("총 수익률은 %.2f%%입니다.")
    }
}
package lotto

class LottoGameMessage {
    companion object {
        const val PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요."
        const val LOTTO_NUMBER = "%d개를 구매했습니다."
        const val WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요."
        const val BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요."
        const val WINNING_RESULT = "당첨 통계\n---"
        const val THREE_MATCHED = "3개 일치 (5,000원) - %d개"
        const val FOUR_MATCHED = "4개 일치 (50,000원) - %d개"
        const val FIVE_MATCHED = "5개 일치 (1,500,000원) - %d개"
        const val FIVE_BONUS_MATCHED = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val SIX_MATCHED = "6개 일치 (2,000,000,000원) - %d개"
        const val TOTAL_RATE = "총 수익률은 %.1f%%입니다."
    }
}
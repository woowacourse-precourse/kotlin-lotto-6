package lotto.model

class Constants {
    companion object{
        val HUNDRED = 100
        val THOUSAND = 1000
        val FIVE_THOUSAND = 5000
        val TEN_THOUSAND = 10000
        val FIFTY_THOUSAND = 50000
        val ONE_MILLION_FIVE_HUNDRED_THOUSAND = 1500000
        val THIRTY_MILLION = 30000000
        val TWO_BILLION = 2000000000
        val ZERO = 0
        val ONE = 1
        val TWO = 2
        val THREE = 3
        val FOUR = 4
        val FIVE = 5
        val SIX = 6

        val WRITE_MONEY = "구입금액을 입력해 주세요."
        val PURCHASE_NUMBER = "개를 구매했습니다."
        val WRITE_JACKPOT = "당첨 번호를 입력해 주세요."
        val WRITE_BONUS = "보너스 번호를 입력해 주세요."
        val COMPARE_ANSWER = "당첨 통계"
        val THREE_DASH = "---"
        val THREE_SAME = "3개 일치 (5,000원) - "
        val FOUR_SAME = "4개 일치 (50,000원) - "
        val FIVE_SAME = "5개 일치 (1,500,000원) - "
        val FIVE_WITH_BONUS_SAME = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        val SIX_SAME = "6개 일치 (2,000,000,000원) - "
        val COUNT = "개"
        val TOTAL_PROFIT = "총 수익률은 "
        val PERCENT = "%입니다."

        val ERROR_RANGE_OVER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        val ERROR_MONEY_FORMAT = "[ERROR] 구매 금액은 숫자여야 합니다."
        val ERROR_NO_CHAGES = "[ERROR] 잔돈은 안받습니다."
        val ERROR_MONEY_RANGE = "[ERROR] 1000원 이상 돈을 주십시오."
        val ERROR_LOTTO_DUPlICATION = "[ERROR] 로또 번호 중복 발견."
        val ERROR_LOTTO_FORMAT = "[ERROR] 로또 번호는 숫자여야 합니다."
        val ERROR_BONUS_DUPLICATION = "[ERROR] 보너스가 답과 중복 됐습니다."
        val ERROR_BONUS_FORMAT = "[ERROR] 보너스는 숫자여야 합니다."
    }
}
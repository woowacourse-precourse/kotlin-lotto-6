package lotto

enum class WinEnum(val win: Int, val printer: String, var counts: Int) {
    FIFTH(5000, "3개 일치 (5,000원) - ${FIFTH.counts}", 0),
    FOURTH(50000, "4개 일치 (50,000원) - ${FOURTH.counts}", 0),
    THIRD(1500000, "5개 일치 (1,500,000원) - ${THIRD.counts}", 0),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ${SECOND.counts}", 0),
    FIRST(2000000000, "6개 일치 (2,000,000,000원) - ${FIRST.counts}", 0)
}
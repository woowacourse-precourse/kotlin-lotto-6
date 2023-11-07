package lotto.Model

data class LottoResult ( // 사용자 번호와 당첨 번호를 비교하는 클래스.
    val matchedCount: Int,
    val hasBonus: Boolean,
)
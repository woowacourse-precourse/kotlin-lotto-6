package lotto

import java.text.NumberFormat
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){ "로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 번호는 중복될 수 없습니다." }
    }
//로또 리스트 크기와 중복 번호 유무 확인
    fun getMatchCount(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }
//로또 번호와 당첨 번호 일치여부 반환
    fun getIsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
//로또 번호 중 보너스 번호가 있는지 확인
    fun getLottoResult(winningNumbers: List<Int>, bonusNumber: Int): LottoResult {
        val matchCount = getMatchCount(winningNumbers)
        val isBonus = getIsBonus(bonusNumber)
        return LottoResult.fromMatchCount(matchCount, isBonus)
    }
//당첨 번호 및 보너스 번호로 로또 결과 반환
    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
    //로또 리스트 번호를 문자열로 변환 후 반환
}

enum class LottoResult(val matchCount: Int, val prize: Int, val isBonus: Boolean = false) {
    NONE(0, 0),
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000),
    FIVE_MATCHES_AND_BONUS(5, 30000000, true);

    companion object {
        fun fromMatchCount(matchCount: Int, isBonus: Boolean): LottoResult {
            return values().find { it.matchCount == matchCount && it.isBonus == isBonus } ?: NONE
        }
        //당첨 번호 갯수와 보너스 번호 여부로 결과 반환
    }

    fun formatPrize(): String {
        return NumberFormat.getNumberInstance().format(prize)
    }
    //상금을 쉼표로 구분하는 문자열로 포맷

    fun getFormattedResult(count: Int): String {
        val formattedPrize = formatPrize()
        return when(this) {
            FIVE_MATCHES_AND_BONUS -> "${matchCount}개 일치, 보너스 볼 일치 (${formattedPrize}원) - ${count}개"
            FIVE_MATCHES -> "${matchCount}개 일치 (${formattedPrize}원) - ${count}개"
            FOUR_MATCHES -> "${matchCount}개 일치 (${formattedPrize}원) - ${count}개"
            THREE_MATCHES -> "${matchCount}개 일치 (${formattedPrize}원) - ${count}개"
            SIX_MATCHES -> "${matchCount}개 일치 (${formattedPrize}원) - ${count}개"
            NONE -> ""
        }
    }
    //결과에 따른 메시지 반환
}
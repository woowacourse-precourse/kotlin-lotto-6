package lotto.model

enum class BonusErrorCode(val message: String) {
    BONUS_NOT_VALID("[ERROR] 보너스 번호가 유효하지 않습니다."),
    BONUS_REPEATED("[ERROR] 보너스 번호가 당첨 번호와 겹치는 번호입니다.")
}
class LottoBonus {
    fun bonusCheck(bonus: String) {
        val bonusNum = bonus.toIntOrNull()
        require(bonusNum != null && bonusNum > 0 && bonusNum <= 45) {
            IllegalArgumentException(BonusErrorCode.BONUS_NOT_VALID.message)
        }
    }
    fun bonusRepeat(bonusNumber: Int, prizeNumber: List<Int>) {
        if(bonusNumber in prizeNumber)
            throw IllegalArgumentException(BonusErrorCode.BONUS_REPEATED.message)
    }

}
package lotto

const val MATCH_3_INCOME = 5000
const val MATCH_4_INCOME = 50000
const val MATCH_5_INCOME = 1500000
const val MATCH_Bonus_INCOME = 30000000
const val MATCH_6_INCOME = 2000000000


class CalculateIncomeRate(getInputMoney: PurchasedLottos) {
    private var totalIncome = 0
    private val inputMoney = getInputMoney.getInputManager().getInputMoney()

    fun calculateTotalIncomeRate(): Double = calculateTotalIncome().toDouble() / inputMoney.toDouble()
    fun calculateTotalIncome(): Int {
        totalIncome += MatchCatalog.Match3.getMatchCount() * MATCH_3_INCOME
        totalIncome += MatchCatalog.Match4.getMatchCount() * MATCH_4_INCOME
        totalIncome += MatchCatalog.Match5.getMatchCount() * MATCH_5_INCOME
        totalIncome += MatchCatalog.MatchBonus.getMatchCount() * MATCH_Bonus_INCOME
        totalIncome += MatchCatalog.Match6.getMatchCount() * MATCH_6_INCOME

        return totalIncome
    }

    fun getTotalIncome() = totalIncome
}
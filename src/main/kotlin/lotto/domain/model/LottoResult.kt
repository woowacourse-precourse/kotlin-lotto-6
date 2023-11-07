package lotto.domain.model

class LottoResult(val result: Map<Rank, Int>) {

    private fun getTotalPrize(): Float {
        return result.map { it.key.getPrize() * it.value }.sum().toFloat()
    }
}

package lotto.domain.winningResult

import java.text.DecimalFormat

class RateOfReturn(private val rate: Double) {
    override fun toString(): String = DecimalFormat("##0.0").format(rate) + UNIT_SUFFIX

    companion object {
        private const val UNIT_SUFFIX = "%"
    }
}
package lotto.util

import lotto.model.Lotto

interface LottosGenerator {
    fun generate(cnt: Int = 1): List<Lotto>
}

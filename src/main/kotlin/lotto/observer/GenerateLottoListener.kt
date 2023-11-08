package lotto.observer

import lotto.model.Lotto

interface GenerateLottoListener {
    fun generateLotto(lotto: List<Lotto>)
}
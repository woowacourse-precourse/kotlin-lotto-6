package lotto.domain.repository

import lotto.domain.model.Lotto

interface LottoRepository {
    fun getLottoes(amount: Int): List<Lotto>
}
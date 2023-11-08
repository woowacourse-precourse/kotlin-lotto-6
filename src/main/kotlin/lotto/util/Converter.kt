package lotto.util

import lotto.model.validation.LottoNumber

object Converter {
    @JvmName("List Int to LottoNumber")
    fun Iterable<Int>.toLottoNumbers(): List<LottoNumber> {
        return this.map { LottoNumber(it.toString()) }
    }

    @JvmName("List String to LottoNumber")
    fun Iterable<String>.toLottoNumbers(): List<LottoNumber> {
        return this.map { LottoNumber(it.trim()) }
    }
}
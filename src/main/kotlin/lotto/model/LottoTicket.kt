package lotto.model

class LottoTicket {
    private var _numbers: MutableList<List<Int>> = mutableListOf()
    val numbers: List<List<Int>>
        get() = _numbers

    fun addNumbers(lottoNumbers: List<Int>) = _numbers.add(lottoNumbers)
}
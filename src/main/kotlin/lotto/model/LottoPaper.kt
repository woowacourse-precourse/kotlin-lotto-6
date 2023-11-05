package lotto.model

class LottoPaper(lottoNum: List<LottoNum>) {
    private var lottoNum: List<LottoNum>

    init {
        //예외처리
        this.lottoNum = lottoNum
    }

    fun getLottoPaper(): List<LottoNum> {
        return lottoNum
    }
}
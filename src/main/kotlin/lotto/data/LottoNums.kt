package lotto.data


data class LottoNums(
    var lottoNums : List<Int>,
    var bonusNum : Int
)

data class LottoResult(
    var three : Long = 0,
    var four : Long = 0 ,
    var five : Long = 0,
    var bonus : Long = 0,
    var six : Long = 0
)
package lotto.data


data class LottoNums(
    var lottoNums : List<Int>,
    var bonusNum : Int
)

data class LottoResult(
    var three : Int = 0,
    var four : Int = 0 ,
    var five : Int = 0,
    var bonus : Int = 0,
    var six : Int = 0,
    )
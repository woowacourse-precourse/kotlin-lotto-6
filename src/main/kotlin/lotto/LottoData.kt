object LottoData {

    var purchaseNum : Int = 0

    var lottoNums : MutableList<List<Int>> = mutableListOf()
    //랜덤으로 뽑은 로또 넘버

    var lottoResult = mutableListOf<Int>()

    var bonusNum = 0

    var stats = mutableMapOf<MatchType, Int>().withDefault { 0 }

    var profitRatio = 0.0


}
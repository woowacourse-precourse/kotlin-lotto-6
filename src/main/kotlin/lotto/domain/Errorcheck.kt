package lotto.domain

fun blankCheck(input : String){
    if(input.isBlank()){
        throw IllegalArgumentException("공백은 안됩니다")
    }
}

fun numberCheck(input : String){
    if(input.toIntOrNull()==null){
        throw IllegalArgumentException("숫자가 아닌값이 있습니다")
    }
}

fun moneyCheck (money:Int){
    if(money%1000!=0){
        throw IllegalArgumentException("1000으로 나누어떨어져야합니다")
    }
}

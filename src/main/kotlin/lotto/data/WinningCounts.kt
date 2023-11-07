package lotto.data

enum class WinningCount(count : Int, bonus :Boolean) {
    THREE(3,false),FOUR(4,false),FIVE(5,false),BONUS(5,true),SIX(6,false);

}
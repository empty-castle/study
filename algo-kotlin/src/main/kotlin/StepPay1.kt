fun main() {

    var answer = 0;
    var goods: Array<Int> = arrayOf(3,8,6)
    var boxes: Array<Int> = arrayOf(5,6,4)

    goods.sortDescending()
    boxes.sortDescending()

    var checkedGoods = 0
    for (box in boxes) {
        while (checkedGoods < goods.size) {
            if (goods[checkedGoods] > box) {
                checkedGoods++
                continue
            }
            checkedGoods++
            answer++
            break
        }
    }

    println(answer)
}
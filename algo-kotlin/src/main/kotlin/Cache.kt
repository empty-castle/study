fun main() {

    var answer = 0;
    val cache = ArrayDeque<String>()
    val cacheSize = 0
    fun search(keyword: String): Int {
        // 검색
        val searchResult = cache.find { it == keyword }
        // 캐쉬에 추가
        cache.add(keyword)
        // 캐쉬 size 유지
        if (cache.size > cacheSize) {
            cache.removeFirst()
        }
        return if (searchResult == null) {
            5
        } else {
            1
        }
    }

    val cities = arrayOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA")

    for (city in cities) {
        answer += search(city)
    }

    println(answer)
}


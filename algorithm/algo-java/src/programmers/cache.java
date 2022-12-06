package programmers;

import java.util.LinkedHashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/17680

public class cache {

    public static void main(String[] args) {

        int answer = 0;
        int cacheSize = 0;
        LRUCache cache = new LRUCache(cacheSize);

        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        for (String city : cities) {
            Integer result = cache.get(city.toUpperCase());
            if (result != null) {
                answer += 1;
            } else {
                answer += 5;
                cache.put(city.toUpperCase(), 1);
            }
        }
        System.out.println(answer);
    }
}
class LRUCache extends LinkedHashMap<String, Integer> {

    private final int cacheSize;

    LRUCache(int cacheSize) {
        super(cacheSize, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > cacheSize;
    }
}



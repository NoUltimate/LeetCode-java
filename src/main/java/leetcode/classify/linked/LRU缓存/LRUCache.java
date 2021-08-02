package leetcode.classify.linked.LRU缓存;
/*
 *
 *
 * @author sunbowen
 * @date 2021年08月02日 10:25
 */

import java.util.*;

class LRUCache {

    Map<Integer, Integer> m;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // LinkedHashMap的accessOrder  Map<String, String> map = new LinkedHashMap<String, String>(16,0.75f,true);
        // initialCapacity   初始容量大小，使用无参构造方法时，此值默认是16
        // loadFactor       加载因子，使用无参构造方法时，此值默认是 0.75f
        // accessOrder   false： 基于插入顺序     true：  基于访问顺序
        m = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            int value = m.get(key);
            m.remove(key);
            m.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            int v = m.get(key);
            m.remove(key);
            m.put(key, v);
        } else {
            if (m.size() == capacity) {
                m.remove(m.keySet().iterator().next());
            }
            m.put(key, value);
        }
    }


    public static void main(String[] args) {
        System.out.println(3/0.75);
    }
}

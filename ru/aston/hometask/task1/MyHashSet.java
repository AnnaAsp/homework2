package aston.hometask.task1;

import java.util.HashMap;

public class MyHashSet<E> {
    private HashMap<E,Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    public boolean add(E element) {
        return map.put(element, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }
}


package aston.hometask.task1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("дерево");
        set.add("дерево");
        set.add("дом");
        set.add("дом");
        set.add("человек");
        set.add("наушник");
        set.remove("наушник");

        System.out.println(set);

        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("чайник");
        list.add("стул");
        list.add("стол");
        list.add("кресло");

        MyLinkedList<String> list2 = new MyLinkedList<>();
        list2.add("очки");
        list2.add("платье");
        list2.add("штаны");

        list.addAll(list2);

        LinkedList<String> list3 = new LinkedList<>();
        list3.add("ночь");
        list3.add("день");

        list.addAll(list3);

        list.remove("стул");

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(1));
        System.out.println(list);

    }
}
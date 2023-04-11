package ru.vsu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueJava {
    public static LinkedList<Queue<String>> Testing(String n) {
        LinkedList<Queue<String>> list = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        String[] str = n.split(" ");
        for (String i : str) {
            queue.add(dubl(i));
        }
        list.add(queue);

        return list;
    }
    public static String dubl(String str) {
        String s = "";
        s += str + ", " + str;
        return s;
    }
    public static LinkedList<Queue<String>> Testing2(String n) {
        LinkedList<Queue<String>> list = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();

        String[] str = n.split(" ");
        queue.addAll(Arrays.asList(str));
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String s = queue.poll(); // Извлекаем элемент из очереди
            queue.offer(s); // Добавляем его в очередь еще раз
            queue.offer(s);
        }
        list.add(queue);
        return list;
    }
}

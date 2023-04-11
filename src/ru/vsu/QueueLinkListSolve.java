package ru.vsu;

import java.util.Arrays;
import java.util.LinkedList;

public class QueueLinkListSolve {
    public static LinkedList<String>  Testing3(String n) {
        SimpleQueue<String> queue = new SimpleLinkedListQueue<>();
        LinkedList<String> list = new LinkedList<>();
        String[] str = n.split(" ");
        for (String i : str) {
            queue.add(i);
            queue.add(i);
        }
        int size = queue.count();
        String[] array = new String[size];
        for (int l = 0; l < size; l++) {
            try {
                array[l] = queue.remove();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        String arr = Arrays.toString(array);
        list.add(arr);
        return list;


    }


}
